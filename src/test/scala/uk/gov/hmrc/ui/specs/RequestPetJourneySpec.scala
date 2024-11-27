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

import uk.gov.hmrc.ui.pages.ClientName

class RequestPetJourneySpec extends BaseSpec {

  private val clientName = ClientName

  Feature("Check VAT flat rate") {

    Scenario("User pays annually and is a limited cost business") {

      Given("my VAT return period is annual")
      clientName.goTo()
      clientName.submit("Test Person")

      And("my turnover for the year is £1000")

      When("my cost of goods for the year is £999")

      Then("I can use the 16.5% VAT flat rate")

    }

  }

}
