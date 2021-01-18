package oppabet.modalWindows.searchWindow

import com.codeborne.selenide.Selenide.`$$`
import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.By

class Content(val element: SelenideElement) {
    val searchResults = element.`$$`(By.xpath(".//div[@class='search-popup-events__item']"))
}