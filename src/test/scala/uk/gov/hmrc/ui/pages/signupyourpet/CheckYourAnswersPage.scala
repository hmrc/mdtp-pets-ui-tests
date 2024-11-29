package uk.gov.hmrc.ui.pages.signupyourpet

import uk.gov.hmrc.ui.pages.patterns.CheckYourAnswersPattern

object CheckYourAnswersPage extends CheckYourAnswersPattern {
  override val url: String = baseUrl + "check-your-answers?journey=2&step=6"
}
