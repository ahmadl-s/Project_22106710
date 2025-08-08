package MyNutritionapp.view

import MyNutritionapp.MainApp
import javafx.fxml.FXML
import javafx.event.ActionEvent
import scalafx.Includes.*
import scalafx.scene.control.Alert.AlertType
import scalafx.scene.control.Alert
import javafx.scene.control.{TextArea, Button}


@FXML
class FeedbackWindowController():
  @FXML
  def handleHome(action: ActionEvent): Unit =
    MainApp.showOpeningWindow()

  @FXML
  private var feedbackTextArea: TextArea = _

  @FXML
  private var submitButton: Button = _

  @FXML
  def handleSubmitFeedback(event: ActionEvent): Unit = {
    // Get the text from the TextArea
    val userFeedback = feedbackTextArea.text.value

    if (userFeedback.trim.nonEmpty) {
      val alert = new Alert(AlertType.Information) {
        title = "Feedback Submitted"
        //        headerText = null
        contentText = s"Thank you for your feedback:\n\n$userFeedback"
      }

      alert.showAndWait()

      feedbackTextArea.text = ""
    } else {
      // Create a warning alert if the user tries to submit empty feedback
      val alert = new Alert(AlertType.Warning) {
        title = "No Feedback Entered"
        //        headerText = null
        contentText = "Please enter your feedback before submitting."
      }
      alert.showAndWait()
    }
  }

