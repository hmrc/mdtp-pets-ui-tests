/*
 * Copyright 2024 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.ui.pages

import org.openqa.selenium.By
import uk.gov.hmrc.configuration.TestEnvironment

import java.time.Year

object RequestAPet extends BasePage {

  private val url: String = TestEnvironment.url("example-ui-journey-tests-prototype") + "/radios?journey=3&step=0"

  override protected val continueButton: By = By.cssSelector(".govuk-button")

  def goToRequestAPetService(): Unit =
    get(url)

  def selectDog(): Unit = {
    val dogRadioButton: By = By.id("answers[journey3][pet-preference]")
    selectCheckbox(dogRadioButton)
    click(continueButton)
  }

  def itWillBeAroundChildren(): Unit = {
    val homeWithChildrenRadioButton: By = By.id("answers[journey3][home-with-children]")
    selectCheckbox(homeWithChildrenRadioButton)
    click(continueButton)
  }

  private val currentYear                     = Year.now().toString
  def itIsWantedFromTheStartOfTheYear(): Unit =
    setDate("1", "1", currentYear)

  def itIsWantedUntilTheEndOfTheYear(): Unit =
    setDate("31", "12", currentYear)

  def setDate(day: String, month: String, year: String): Unit = {

    sendKeys(By.id("passport-issued-day"), day)
    sendKeys(By.id("passport-issued-month"), month)
    sendKeys(By.id("passport-issued-year"), year)
    click(continueButton)
  }

  def confirmAnswers(): Unit =
    click(By.cssSelector(".govuk-button"))

  def payADeposit(): Unit = {
    sendKeys(By.id("name-on-the-account"), "Joe Bloggs")
    sendKeys(By.id("sort-code"), "112233")
    sendKeys(By.id("account-number"), "12345678")
    click(By.cssSelector(".govuk-button"))
  }

  def requestADogAndProvideRequiredInformation(): Unit = {
    selectDog()
    itWillBeAroundChildren()
    itIsWantedFromTheStartOfTheYear()
    itIsWantedUntilTheEndOfTheYear()
    confirmAnswers()
    payADeposit()
  }

  def petConfirmation: String =
    getText(By.tagName("h1"))

  val successful: String = "Pet requested"
}
