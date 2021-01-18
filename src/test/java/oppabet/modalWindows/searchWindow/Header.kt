package oppabet.modalWindows.searchWindow

import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.By

class Header(val element: SelenideElement) {
    val title = element.`$`(By.xpath(".//div[@class='search-popup__title']")).`as`("title")
    val searchResult = element.`$`(By.xpath(".//span")).`as`("Table of result")
    fun checkBox(name: String) = element
        .`$`(By.xpath(".//div[@class='c-checkbox' and ./label[text()='$name']]")).`as`("checkbox '$name'")
    val searchField = element.`$`(By.id("search-in-popup")).`as`("search field")
    val clearSearchFieldBtn = element.`$`(By.xpath(".//div[@class='search-popup__clear']")).`as`("clear field button")
    val searchBtn = element.`$`(By.xpath(".//button")).`as`("search button")
}