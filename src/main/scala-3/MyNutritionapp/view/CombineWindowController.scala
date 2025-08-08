package MyNutritionapp.view

import MyNutritionapp.MainApp
import MyNutritionapp.MainApp.{showAnalysisWindow, stage}
import MyNutritionapp.model
import MyNutritionapp.model.FoodItem
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.{Label, TableColumn, TableView}
import scalafx.stage.Stage
import scalafx.Includes.*
import javafx.scene.control.SelectionMode

import scala.jdk.CollectionConverters.*


@FXML
class CombineWindowController():

  @FXML
  private var foodTableView: TableView[FoodItem] = null
  @FXML
  private var foodNameColumn: TableColumn[FoodItem, String] = null
  @FXML
  private var totalCaloriesLabel: Label = null
  @FXML
  private var totalProteinLabel: Label = null
  @FXML
  private var totalCarbohydratesLabel: Label = null
  @FXML
  private var totalFatLabel: Label = null
  @FXML
  private var totalFiberLabel: Label = null
  @FXML
  private var totalSugarLabel: Label = null

  @FXML
  def handleBack(action: ActionEvent): Unit =
    MainApp.showMainWindow()

  def initialize(): Unit =
    foodTableView.items = MainApp.foodData
    // initialize columns's cell values
    foodNameColumn.cellValueFactory = _.value.name
    foodTableView.selectionModel().selectionMode = SelectionMode.MULTIPLE



//  def sumSelectedCalories(): Double = {
//    // Get the list of selected Food items from the table
//    val selectedFoods = foodTableView.selectionModel().getSelectedItems
//    selectedFoods.toSeq.map(_.calories.value).sum
//  }
//
//  def sumSelectedProtein(): Double = {
//    val selectedFoods = foodTableView.selectionModel().getSelectedItems
//    selectedFoods.toSeq.map(_.protein.value).sum
//  }
//
//  def sumSelectedCarbohydrates(): Double = {
//    val selectedFoods = foodTableView.selectionModel().getSelectedItems
//    selectedFoods.toSeq.map(_.carbohydrates.value).sum
//  }
//
//  def sumSelectedFat(): Double = {
//    val selectedFoods = foodTableView.selectionModel().getSelectedItems
//    selectedFoods.toSeq.map(_.fat.value).sum
//  }
//
//  def sumSelectedFiber(): Double = {
//    val selectedFoods = foodTableView.selectionModel().getSelectedItems
//    selectedFoods.toSeq.map(_.fiber.value).sum
//  }
//
//  def sumSelectedSugar(): Double = {
//    val selectedFoods = foodTableView.selectionModel().getSelectedItems
//    selectedFoods.toSeq.map(_.sugar.value).sum
//

  def sumSelectedAttribute(attributeExtractor: FoodItem => Double): Double = {
    val selectedFoods = foodTableView.selectionModel().getSelectedItems
    selectedFoods.toSeq.map(attributeExtractor).sum
  }

  @FXML
  def handleCalculate(): Unit = {
    //     val total = sumSelectedCalories()

    MainApp.totalCalories = sumSelectedAttribute(_.calories.value)
    MainApp.totalProtein = sumSelectedAttribute(_.protein.value)
    MainApp.totalCarbohydrates = sumSelectedAttribute(_.carbohydrates.value)
    MainApp.totalFat = sumSelectedAttribute(_.fat.value)
    MainApp.totalFiber = sumSelectedAttribute(_.fiber.value)
    MainApp.totalSugar = sumSelectedAttribute(_.sugar.value)

    totalCaloriesLabel.text = f"Total Calories: ${MainApp.totalCalories}%.2f"
    totalProteinLabel.text = f"Total Protein: ${MainApp.totalProtein}%.2f"
    totalCarbohydratesLabel.text = f"Total Carbohydrates: ${MainApp.totalCarbohydrates}%.2f"
    totalFatLabel.text = f"Total Fat: ${MainApp.totalFat}%.2f"
    totalFiberLabel.text = f"Total Fiber: ${MainApp.totalFiber}%.2f"
    totalSugarLabel.text = f"Total Sugar: ${MainApp.totalSugar}%.2f"
  }
  

  @FXML
  def handleAnalysis(action: ActionEvent): Unit = {
    MainApp.showAnalysisWindow()

  }

  @FXML
  def handleInstructionWindow(action: ActionEvent): Unit = {
    MainApp.showInstructionsWindow()
  }










































