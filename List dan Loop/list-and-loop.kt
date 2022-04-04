open class Item(val name: String, val price: Int)

class Noodles : Item("Noodles", 10) {
  override fun toString(): String {
    return name
  }
}

class Vegetables(val toppings: List<String>) : Item("Vegetables", 5) {
  override fun toString(): String {
    return name
  }
}

fun main() {
  val noodles = Noodles()
  val vegetables = Vegetables("Cabbage", "Sprouts", "Onion")
  println(noodles)
  println(vegetables)
}