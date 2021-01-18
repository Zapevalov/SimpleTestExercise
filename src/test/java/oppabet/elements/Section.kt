package oppabet.elements

import com.codeborne.selenide.CollectionCondition
import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$$`
import com.codeborne.selenide.Selenide.`$`
import io.qameta.allure.Step
import oppabet.modalWindows.searchWindow.SearchWindow
import org.openqa.selenium.By

class Section(private val title: String) {
    val section = `$`(By.xpath("//section[@class='c-section' and .//h2/span[text() = '$title']]")).`as`("Секция $title")

    val header = SectionHeader(section.`$`(By.xpath(".//div[@class='c-section__header ']")))

    val dashBoardChampItem = `$$`(By.xpath(".//div[@data-name='dashboard-champ-content']"))

    @Step("Search events by name of club \"{clubName}\"")
    fun searchEventsForClub(clubName: String){
        header.searchField.`val`(clubName.trim()).pressEnter()

        SearchWindow().apply {
            header.title.shouldHave(Condition.text("events found"))
            header.searchField.shouldHave(Condition.value(clubName))

            //not the best implementation of working with tabs here, but laaazy
            content("matches").searchResults.apply {
                shouldHaveSize(header.searchResult.text().toInt())
                    .shouldBe(
                        CollectionCondition
                            .allMatch(
                                "Every item have club name: $clubName in text"
                            ) { x -> x.text.contains(clubName) })
            }
            closeBtn.click()
        }.header.element.shouldBe(Condition.disappear)
    }
}