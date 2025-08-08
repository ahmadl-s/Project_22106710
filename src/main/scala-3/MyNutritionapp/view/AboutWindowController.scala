package MyNutritionapp.view

import javafx.event.ActionEvent
import javafx.fxml.FXML
import scalafx.stage.Stage

@FXML
class AboutWindowController():
  var stage: Option[Stage] = None
  var okCliked = false

  @FXML
  def handleClose(action: ActionEvent): Unit =
    okCliked = true
    stage.foreach(x => x.close())

