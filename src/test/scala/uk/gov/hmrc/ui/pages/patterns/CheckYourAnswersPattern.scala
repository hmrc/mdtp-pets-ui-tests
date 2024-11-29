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
