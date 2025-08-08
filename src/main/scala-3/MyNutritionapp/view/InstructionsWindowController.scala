package MyNutritionapp.view

import javafx.fxml.FXML
import scalafx.stage.Stage
import javafx.event.ActionEvent


@FXML
class InstructionsWindowController():
  var stage: Option[Stage] = None
  var okCliked = false

  @FXML
  def handleClose(action: ActionEvent): Unit =
    okCliked = true
    stage.foreach(x => x.close())