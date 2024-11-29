package uk.gov.hmrc.ui.pages.signupyourpet

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.BasePage

object IsYourPetVaccinatedPage extends BasePage {
  val url: String = baseUrl + "radios?journey=2&step=1"

  override def isCurrentPage: Boolean = getCurrentUrl == url

  def selectYes(): Unit = {
    click(By.xpath("//label[contains(text(), 'Yes')]"))
    click(By.xpath("//button[@type='submit']"))
  }
}
