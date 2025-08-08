package MyNutritionapp.view

import javafx.fxml.FXML
import MyNutritionapp.MainApp

@FXML
class OpeningWindowController():
  @FXML
  def handleStart(): Unit =
    MainApp.showMainWindow()


