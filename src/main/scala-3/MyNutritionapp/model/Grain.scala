package MyNutritionapp.model

class Grain(
             name: String,
             calories: Double,
             protein: Double,
             carbohydrates: Double,
             fat: Double,
             fiber: Double,
             sugar: Double
           ) extends FoodItem(name, calories, protein, carbohydrates, fat, fiber, sugar) {
  override def getFoodType(): String = "Grain"
}