/*
 * Copyright 2025 HM Revenue & Customs
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

package uk.gov.hmrc.ui.pages.patterns

import org.openqa.selenium.By
import uk.gov.hmrc.selenium.webdriver.Driver
import uk.gov.hmrc.ui.pages.BasePage

import scala.jdk.CollectionConverters._

trait CheckYourAnswersPattern extends BasePage {
  val url: String

  override def isCurrentPage: Boolean = getCurrentUrl == url

  def answers: Seq[(String, String)] = {
    val questions = Driver.instance.findElements(By.className("govuk-summary-list__key")).asScala.map(_.getText.trim)
    val answers   = Driver.instance.findElements(By.className("govuk-summary-list__value")).asScala.map(_.getText.trim)
    questions.zip(answers).toSeq
  }

  def acceptAndContinue(): Unit =
    click(By.xpath("//button[@type='submit']"))
}
