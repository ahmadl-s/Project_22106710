package MyNutritionapp.model

import scalafx.beans.property.{ObjectProperty, StringProperty}

// Represents a generic food item with common nutritional attributes.
abstract class FoodItem(
                         val _name: String,
                         val _calories: Double,
                         val _protein: Double,
                         val _carbohydrates: Double,
                         val _fat: Double,
                         val _fiber: Double,
                         val _sugar: Double
                       ) {

  val name: StringProperty = StringProperty(_name)
  val calories: ObjectProperty[Double] = ObjectProperty[Double](_calories)
  val protein: ObjectProperty[Double] = ObjectProperty[Double](_protein)
  val carbohydrates: ObjectProperty[Double] = ObjectProperty[Double](_carbohydrates)
  val fat: ObjectProperty[Double] = ObjectProperty[Double](_fat)
  val fiber: ObjectProperty[Double] = ObjectProperty[Double](_fiber)
  val sugar: ObjectProperty[Double] = ObjectProperty[Double](_sugar)
  
  // Abstract method to be implemented by subclasses, defining the food type.
  def getFoodType(): String

  // Optional: A toString method for easy printing and debugging
  override def toString: String =
    s"Name: $name, Type: ${getFoodType()}, Calories: $calories g, Protein: $protein g, Carbs: $carbohydrates g, Fat: $fat g, Fiber: $fiber g, Sugar: $sugar g"
}