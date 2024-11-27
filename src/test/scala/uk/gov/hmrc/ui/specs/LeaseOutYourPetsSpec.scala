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

import uk.gov.hmrc.ui.specs.BaseSpec

class LeaseOutYourPetsSpec extends BaseSpec {
  System.setProperty("browser", "chrome") // temp, just to make it easier to run from IDE

  info("As a pet owner")
  info("I want to be able to lease out my pet")
  info("So that I can supplement my income")

  Feature("Sign-up your pet") {
    Scenario("Sign-up is successful, when all information can be provided") {
      // I start the sign-up process
      // I am asked to enter my pets name
      // I enter my pets name
      // I am asked if my pet is vaccinated
      // I select yes
      // I am asked when my pets next vaccination is due
      // I enter the date of my pets next vaccination
      // I am asked how old my pet is
      // I enter my pets age
      // I am asked how big my pet is
      // I select how big my pet is
      // I am asked if my pet is suitable for a home with children
      // I select yes
      // I am asked to confirm the details I've entered are correct
      // I confirm the details are correct
      // My pet is signed up successfully
      // I receive an email confirming my pet is signed up
      // I can see my pet listed in my account
    }
  }

}
