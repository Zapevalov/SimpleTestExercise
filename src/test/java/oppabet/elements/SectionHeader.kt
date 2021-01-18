package oppabet.elements

import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.By

class SectionHeader( val element: SelenideElement) {
    val title= element.`$`(By.id("page_title"))

    val searchField = element.`$`(By.xpath(".//input"))
}