package oppabet.modalWindows.searchWindow

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import org.openqa.selenium.By

class SearchWindow {
    init {
        `$`(By.xpath("//div[@class='search-popup v-modal-search']"))
            .shouldBe(Condition.and("Окно появилось и оно на переднем плане", Condition.appear))
    }
    val closeBtn = `$`(By.xpath("//div[@class='search-popup__close']"))
        .shouldHave(Condition.visible)
    val header = Header(`$`(By.xpath("//div[@class='search-popup__header']")))
    fun content(tabName: String) = Content(`$`(By.xpath("//div[@class='search-popup-tabs' and //*[contains(text(),'$tabName')]]")))
}