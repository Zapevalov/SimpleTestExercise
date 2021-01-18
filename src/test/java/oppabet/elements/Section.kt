package oppabet.elements

import com.codeborne.selenide.Selenide.`$$`
import com.codeborne.selenide.Selenide.`$`
import org.openqa.selenium.By

class Section(private val title: String) {
    val section = `$`(By.xpath("//section[@class='c-section' and .//h2/span[text() = '$title']]"))

    val header = SectionHeader(section.`$`(By.xpath(".//div[@class='c-section__header ']")))

    val dashBoardChampItem = `$$`(By.xpath(".//div[@data-name='dashboard-champ-content']"))
}