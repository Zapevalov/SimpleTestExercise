package oppabet

import com.codeborne.selenide.Selenide.`$`
import oppabet.elements.Section
import org.openqa.selenium.By

class OppabetPage {
    fun getSection(titleSection: String) = Section(titleSection)
}