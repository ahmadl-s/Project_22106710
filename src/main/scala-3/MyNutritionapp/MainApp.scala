package MyNutritionapp


import MyNutritionapp.view.{AboutWindowController, CombineWindowController, FeedbackWindowController, InstructionsWindowController}
import javafx.fxml.FXMLLoader
import scalafx.stage.Stage
import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.scene.Scene
import MyNutritionapp.model.{FoodItem, Fruit, Grain, Meat, Vegetable}

import java.net.URL
import scalafx.Includes.*
import scalafx.collections.ObservableBuffer
import scalafx.stage.Modality.ApplicationModal





object MainApp extends JFXApp3:

  var rootPane: Option[javafx.scene.layout.BorderPane] = None

  val foodData = new ObservableBuffer[FoodItem]()


    foodData += new Grain("Rice", 130, 2.7, 28, 0.3, 0.4, 0.1)
    foodData += new Meat("Chicken Breast", 165, 31, 0, 3.6, 0, 0)
    foodData += new Fruit("Apple", 52, 0.3, 14, 0.2, 2.4, 10.4)
    foodData += new Vegetable("Carrot", 41, 0.9, 10, 0.2, 2.8, 4.7)

  // Combine all into a single list of FoodItem

  var totalCalories: Double = 0.0
  var totalProtein: Double = 0.0
  var totalCarbohydrates: Double = 0.0
  var totalFat: Double = 0.0
  var totalFiber: Double = 0.0
  var totalSugar: Double = 0.0


  override def start(): Unit = {
    val rootLayoutResource: URL = getClass.getResource("/MyNutritionapp/view/RootLayout.fxml")
    val loader = new FXMLLoader(rootLayoutResource)
    val rootLayout = loader.load[javafx.scene.layout.BorderPane]()
    rootPane = Option(loader.getRoot[javafx.scene.layout.BorderPane]())
    stage = new PrimaryStage():
      title = "My Nutrition App"
      scene = new Scene():
        root = rootLayout
    showOpeningWindow()
  }

  def showOpeningWindow(): Unit =
    val OpeningWindowResource = getClass.getResource("/MyNutritionapp/view/OpeningWindow.fxml")
    val loader = new FXMLLoader(OpeningWindowResource)
    val OpeningWindowPane = loader.load[javafx.scene.layout.AnchorPane]()
    rootPane.foreach(_.setCenter(OpeningWindowPane))

  def showMainWindow(): Unit = {
    val MainWindowResource = getClass.getResource("/MyNutritionapp/view/MainWindow.fxml")
    val loader = new FXMLLoader(MainWindowResource)
    val MainWindowPane = loader.load[javafx.scene.layout.AnchorPane]()
    rootPane.foreach(_.setCenter(MainWindowPane))
}


  def showAboutWindow(): Boolean = {
    val aboutResource = getClass.getResource("/MyNutritionapp/view/AboutWindow.fxml")
    val loader = new FXMLLoader(aboutResource)
    loader.load()
    val AboutWindowpane = loader.getRoot[javafx.scene.layout.AnchorPane]()
    val aboutWindowStage = new Stage():
      initOwner(stage)
      initModality(ApplicationModal)
      title = "About"
      scene = new Scene():
        root = AboutWindowpane
    val ctrl = loader.getController[AboutWindowController]()
    ctrl.stage = Option(aboutWindowStage)
    aboutWindowStage.showAndWait()
    ctrl.okCliked

  }

  def showCombineWindow(): Unit = {
    val CombineWindowResource = getClass.getResource("/MyNutritionapp/view/CombineWindow.fxml")
    val loader = new FXMLLoader(CombineWindowResource)
    val CombineWindowPane = loader.load[javafx.scene.layout.AnchorPane]()
    rootPane.foreach(_.setCenter(CombineWindowPane))
  }

  def showAnalysisWindow(): Unit = {
    val AnalysisWindowResource = getClass.getResource("/MyNutritionapp/view/AnalysisWindow.fxml")
    val loader = new FXMLLoader(AnalysisWindowResource)
    val AnalysisWindowPane = loader.load[javafx.scene.layout.AnchorPane]()
    rootPane.foreach(_.setCenter(AnalysisWindowPane))
  }

  def showFeedbackWindow(): Unit = {
    val FeedbackWindowResource = getClass.getResource("/MyNutritionapp/view/FeedbackWindow.fxml")
    val loader = new FXMLLoader(FeedbackWindowResource)
    val FeedbackWindowPane = loader.load[javafx.scene.layout.AnchorPane]()
    rootPane.foreach(_.setCenter(FeedbackWindowPane))
  }

  def showInstructionsWindow(): Unit = {
    val InstructionResource = getClass.getResource("/MyNutritionapp/view/InstructionsWindow.fxml")
    val loader = new FXMLLoader(InstructionResource)
    loader.load()
    val InstructionWindowpane = loader.getRoot[javafx.scene.layout.AnchorPane]()
    val InstructionWindowStage = new Stage():
      initOwner(stage)
      initModality(ApplicationModal)
      title = "Instructions and Tips"
      scene = new Scene():
        root = InstructionWindowpane
    val ctrl = loader.getController[InstructionsWindowController]()
    ctrl.stage = Option(InstructionWindowStage)
    InstructionWindowStage.showAndWait()
    ctrl.okCliked
  }














