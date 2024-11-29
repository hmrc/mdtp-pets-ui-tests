package uk.gov.hmrc.ui.pages

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.signupyourpet.WhatIsYourPetsNamePage

object SignUpPetJourney extends BasePage {
  override def isCurrentPage: Boolean = WhatIsYourPetsNamePage.isCurrentPage

  def start(): Unit = {
    get(baseUrl)
    click(By.linkText("Sign up your pet"))
  }
}
