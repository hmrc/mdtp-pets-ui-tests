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

package uk.gov.hmrc.ui.pages

import org.openqa.selenium.By

object ClientChoice extends BasePage {

  private val inputField: By = By.className("govuk-radios__item")

  def submit(value: String): Unit = {
    Thread.sleep(1000)
    val radioAnswer: String =
      value match {
        case "cats" => "answers[journey1][pet-preference]-1"
        case "dogs" => "answers[journey1][pet-preference]-2"
        case _      => "NO such pet"
      }
    selectByValue(inputField, radioAnswer)
    click(continueButton)
  }

}