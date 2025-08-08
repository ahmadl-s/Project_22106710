package MyNutritionapp.view

import MyNutritionapp.MainApp
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.layout.AnchorPane
import scalafx.Includes.*
import scalafx.scene.chart.PieChart
import scalafx.scene.chart.PieChart.Data


@FXML
class AnalysisWindowController():
  @FXML
  def handleBack(action: ActionEvent): Unit = {
    MainApp.showCombineWindow()
  }

  @FXML
  var AnalysisLabel: Label = null
  @FXML
    private var chartPane: AnchorPane = _

  private def createPieChart(): PieChart = {
    val pieChart = new PieChart {
      data = Seq(
        Data("Protein", MainApp.totalProtein),
        Data("Carbohydrate", MainApp.totalCarbohydrates),
        Data("Fat", MainApp.totalFat),
        Data("Fiber", MainApp.totalFiber),
        Data("Sugar", MainApp.totalSugar)
      )
      clockwise = false

    }
    pieChart
  }

  @FXML
  def initialize(): Unit = {
    // Create the chart and add it to the pane.
    val chart = createPieChart()
    chartPane.children.add(chart)


    AnalysisLabel.text = generateReview()

    AnchorPane.setTopAnchor(chart, 0.0)
    AnchorPane.setBottomAnchor(chart, 0.0)
    AnchorPane.setLeftAnchor(chart, 0.0)
    AnchorPane.setRightAnchor(chart, 0.0)
  }

  def generateReview(): String = {
    val sb = new StringBuilder
    sb.append(s"Based on your selection, the total calories are ${"%.2f".format(MainApp.totalCalories)} kcal.\n")
    sb.append(s"You have consumed ${"%.2f".format(MainApp.totalProtein)}g of protein, ")
    sb.append(s"${"%.2f".format(MainApp.totalCarbohydrates)}g of carbohydrates, ")
    sb.append(s"${"%.2f".format(MainApp.totalFat)}g of fat, ")
    sb.append(s"${"%.2f".format(MainApp.totalFiber)}g of fiber, and ")
    sb.append(s"${"%.2f".format(MainApp.totalSugar)}g of sugar.\n\n")

    if (MainApp.totalCalories < 500) {
      sb.append("This combination is relatively low in calories. Consider if it meets your energy needs.")
    } else if (MainApp.totalCalories > 1500) {
      sb.append("This combination is quite high in calories. Be mindful of your daily intake.")
    } else {
      sb.append("The calorie count for this combination seems moderate.")
    }

    if (MainApp.totalProtein > 50) {
      sb.append("\nExcellent protein intake for muscle support!")
    } else if (MainApp.totalProtein < 20) {
      sb.append("\nConsider adding more protein sources to your meal.")
    }

    if (MainApp.totalFiber > 10) {
      sb.append("\nGood fiber intake, beneficial for digestion.")
    } else if (MainApp.totalFiber < 5) {
      sb.append("\nTry to include more fiber-rich foods.")
    }

    if (MainApp.totalSugar > 30) {
      sb.append("\nThis combination is high in sugar. Moderation is advised.")
    }

    sb.toString()
  }

  @FXML
  def handleInstructionWindow(action: ActionEvent): Unit = {
    MainApp.showInstructionsWindow()
  }