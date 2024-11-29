package uk.gov.hmrc.ui.pages.signupyourpet

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.BasePage

object WhatIsYourPetsNamePage extends BasePage {
  val url: String = baseUrl + "text-input?journey=2&step=0"

  override def isCurrentPage: Boolean = getCurrentUrl == url

  def enterName(name: String): Unit = {
    sendKeys(By.name("answers[journey2][name]"), name)
    click(By.xpath("//button[@type='submit']"))
  }
}
