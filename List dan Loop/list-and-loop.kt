open class Item(val name: String, val price: Int)

class Noodles : Item("Noodles", 10) {
  override fun toString(): String {
    return name
  }
}

class Vegetables(vararg val toppings: String) : Item("Vegetables", 5) {
  override fun toString(): String {
    if (toppings.isEmpty()) {
        return "$name Chef's Choice"
    } else {
        return name + " " + toppings.joinToString()
    }
  }
}

class Order(val orderNumber: Int) {
   private val itemList = mutableListOf<Item>()

   fun addItem(newItem: Item) {
   }

   fun addAll(newItems: List<Item>) {
   }

   fun print() {
   }
}

fun main() {
  val noodles = Noodles()
  val vegetables = Vegetables("Cabbage", "Sprouts", "Onion")
  val vegetables2 = Vegetables()
  println(noodles)
  println(vegetables)
}