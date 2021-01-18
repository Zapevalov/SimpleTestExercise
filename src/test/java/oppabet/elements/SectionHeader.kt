package oppabet.elements

import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.By

class SectionHeader( val element: SelenideElement) {
    val title= element.`$`(By.id("page_title")).`as`("Title in header's section")

    val searchField = element.`$`(By.xpath(".//input")).`as`("search field")
}