open class Item(val name: String, val price: Int)

class Noodles(vararg val toppings: String) : Item("Noodles", 10) {
  override fun toString(): String {
    if (toppings.isEmpty()) {
        return "$name Chef's Choice"
    } else {
        return name + " " + toppings.joinToString()
    }
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
    itemList.add(newItem)
  }

  fun addAll(newItems: List<Item>) {
    itemList.addAll(newItems)
  }

  fun print() {
    println("Order #${orderNumber}")
    var total = 0
    for (item in itemList) {
      println("${item}: $${item.price}")
      total += item.price
    }
    println("Total: $${total}")
  }
}

fun main() {
  val noodles = Noodles()
  val vegetables = Vegetables("Cabbage", "Sprouts", "Onion")
  val vegetables2 = Vegetables()
  println(noodles)
  println(vegetables)
}