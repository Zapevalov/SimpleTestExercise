import com.codeborne.selenide.CollectionCondition
import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.selenide.AllureSelenide
import oppabet.OppabetPage
import oppabet.modalWindows.searchWindow.SearchWindow
import org.openqa.selenium.By
import org.testng.annotations.Test
import java.util.function.Predicate

class SimpleWebTest {
    init {
        SelenideLogger.addListener("AllureSelenide",
            AllureSelenide().screenshots(true).savePageSource(false))
    }

    @Test
    fun weCanCloseSearchWindow() {
        OppabetPage().apply {
            open("https://www.oppabet.com/")
            getSection("LIVE Bets").header
                .searchField.`val`("ставки на спорт").pressEnter()

            SearchWindow().apply {
                closeBtn.click()
                closeBtn.shouldBe(Condition.not(Condition.exist))
            }
        }
    }

    @Test
    fun weCanSeeSearchResults() {
        OppabetPage().apply {
            open("https://www.oppabet.com/")

            getSection("LIVE Bets").apply {
                //for this part we must write separate objects and fields
                val clubName = dashBoardChampItem[0].`$`(By.xpath(".//div[@class='c-events__team']"))
                    .shouldBe(Condition.exist)
                    .text()

                header.searchField.`val`(clubName.trim()).pressEnter()

                //in init moment we check appearing active window on a page
                SearchWindow().apply {
                    header.title.shouldHave(Condition.text("events found"))
                    header.searchField.shouldHave(Condition.value(clubName))

                    //not the best implementation of working with tabs here, but laaazy
                    content("matches").searchResults.apply {
                        shouldHaveSize(header.searchResult.text().toInt())
                            .shouldBe(CollectionCondition
                                .allMatch(
                                    "Every item have club name: $clubName in text"
                                ) { x -> x.text.contains(clubName) })
                    }
                    closeBtn.click()
                }.header.element.shouldBe(Condition.disappear)
            }
        }
    }

    @Test
    // here we get more clear code, but it's less control because appears new layer
    fun weCanSeeSearchResultsLikePageIbject() {
        OppabetPage().apply {
            open("https://www.oppabet.com/")

            getSection("LIVE Bets").apply {
                val clubName = dashBoardChampItem[0].`$`(By.xpath(".//div[@class='c-events__team']"))
                    .shouldBe(Condition.exist)
                    .text()

                searchEventsForClub(clubName)
            }
        }
    }

}