open class Item(val name: String, val price: Int)

class Noodles : Item("Noodles", 10)

class Vegetables : Item("Vegetables", 5)

fun main() {
    val noodles = Noodles()
    val vegetables = Vegetables()
    println(noodles)
    println(vegetables)
}