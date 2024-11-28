/*
 * Copyright 2023 HM Revenue & Customs
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

import uk.gov.hmrc.ui.pages.{ClientAddress, ClientChoice, ClientConfirmation, ClientDOB, ClientEmail, ClientName, ClientUpload}

class CreateAccountJourneySpec extends BaseSpec {

  private val clientName         = ClientName
  private val clientEmail        = ClientEmail
  private val clientAddress      = ClientAddress
  private val clientDOB          = ClientDOB
  private val clientUpload       = ClientUpload
  private val clientChoice       = ClientChoice
  private val clientConfirmation = ClientConfirmation

  Feature("Create an Account") {

    Scenario("User creates an account to use the service and is a cat person") {

      Given("my Name is Test Person")
      clientName.goTo()
      clientName.submit("Test Person")

      Then("my email is test@test.com")
      clientEmail.submit("test@test.com")

      Then("my location is Testford")
      clientAddress.submit("Testford")

      Then("my date of birth is 1/1/2001")
      clientDOB.submit("1/1/2001")

      Then("my file is uploaded")
      clientUpload.submit("TestFile")

      When("i like cats")
      clientChoice.submit("cats")

      Then("my confirmation page is displayed")
      clientConfirmation.outcome()

    }

    Scenario("User creates an account to use the service and is a dog person") {

      Given("my VAT return period is annual")
      clientName.goTo()
      clientName.submit("Test Two Person")

      Then("my email is test@test.com")
      clientEmail.submit("test@test.com")

      Then("my location is Testford")
      clientAddress.submit("Testford")

      Then("my date of birth is 1/1/2001")
      clientDOB.submit("1/1/2001")

      Then("my file is uploaded")
      clientUpload.submit("TestFile")

      When("i like dogs")
      clientChoice.submit("dogs")

      Then("my confirmation page is displayed")
      clientConfirmation.outcome()

    }

  }

}
