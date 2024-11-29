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
package uk.gov.hmrc.ui.specs

import uk.gov.hmrc.selenium.webdriver.Driver
import uk.gov.hmrc.ui.pages.SignUpPetJourney
import uk.gov.hmrc.ui.pages.signupyourpet._

class LeaseOutYourPetsSpec extends BaseSpec {
  // temp, just to make it easier to run from IDE
  System.setProperty("browser", "chrome")
  System.setProperty("environment", "local")
  System.setProperty("browser.option.headless", "false")

  info("As a pet owner")
  info("I want to be able to lease out my pet")
  info("So that I can supplement my income")

  Feature("Sign-up your pet") {
    Scenario("Sign-up is successful, when all information can be provided") {
      When("I start the sign-up process")
      SignUpPetJourney.start()

      Then("I am asked to enter my pets name")
      on(WhatIsYourPetsNamePage)

      When("I enter my pets name")
      WhatIsYourPetsNamePage.enterName("bob")

      Then("I am asked if my pet is vaccinated")
      on(IsYourPetVaccinatedPage)

      When("I select yes")
      IsYourPetVaccinatedPage.selectYes()

      // I am asked when my pets next vaccination is due
      // I enter the date of my pets next vaccination

      // I am asked how old my pet is
      // I enter my pets age

      // I am asked how big my pet is
      // I select how big my pet is

      // I am asked if my pet is suitable for a home with children
      // I select yes

      Then("I am asked to confirm the details I've entered are correct")
      Driver.instance.get(CheckYourAnswersPage.url) // to skip implementing other steps
      on(CheckYourAnswersPage)

      When("I confirm the details are correct")
      CheckYourAnswersPage.answers shouldBe Seq(
        "Their name"               -> "bob",
        "Their age"                -> "not provided",
        "Their size"               -> "not provided",
        "Vaccinated?"              -> "yes",
        "Date of next vaccination" -> "not provided",
        "Housable with children?"  -> "not provided"
      )
      CheckYourAnswersPage.acceptAndContinue()

      // My pet is signed up successfully
      // I receive an email confirming my pet is signed up
      // I can see my pet listed in my account
    }
  }

}
