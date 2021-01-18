package oppabet.modalWindows.searchWindow

import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.By

class Header(val element: SelenideElement) {
    val title = element.`$`(By.xpath(".//div[@class='search-popup__title']"))
    val searchResult = element.`$`(By.xpath(".//span"))
    fun checkBox(name: String) = element.`$`(By.xpath(".//div[@class='c-checkbox' and ./label[text()='$name']]"))
    val searchField = element.`$`(By.id("search-in-popup"))
    val clearSearchFieldBtn = element.`$`(By.xpath(".//div[@class='search-popup__clear']"))
    val searchBtn = element.`$`(By.xpath(".//button"))
}