/**
* Program yang mengimplementasikan kelas untuk berbagai jenis tempat tinggal.
* Caranya:
* Buat hierarki kelas, variabel, dan fungsi dengan pewarisan,
* kelas abstrak, override, dan variabel privat vs. publik.
*/

import kotlin.math.PI
import kotlin.math.sqrt

fun main() {
    
    val squareCabin = SquareCabin(6, 50.0)
    val roundHut = RoundHut(3, 10.0)
    val roundTower = RoundTower(4, 15.5)

    with(squareCabin) {
        println("\nSquare Cabin\n============")
        println("Material: ${buildingMaterial}")
        println("Capacity: ${capacity}")
        println("Has room? ${hasRoom()}")
        println("Floor area: %.2f".format(floorArea()))
    }

    with(roundHut) {
        println("\nRound Hut\n=========")
        println("Material: ${buildingMaterial}")
        println("Capacity: ${capacity}")
        println("Has room? ${hasRoom()}")
        getRoom()
        println("Has room? ${hasRoom()}")
        getRoom()
        println("Floor area: %.2f".format(floorArea()))
        println("Carpet size: ${calculateMaxCarpetSize()}")
    }

    with(roundTower) {
        println("\nRound Tower\n==========")
        println("Material: ${buildingMaterial}")
        println("Capacity: ${capacity}")
        println("Has room? ${hasRoom()}")
        println("Floor area: %.2f".format(floorArea()))
        println("Carpet size: ${calculateMaxCarpetSize()}")
    }
}

/**
* Mendefinisikan properti umum untuk semua tempat tinggal.
* Semua tempat tinggal memiliki luas lantai,
* tetapi perhitungannya khusus untuk subclass.
* Memeriksa dan mendapatkan kamar diterapkan di sini
* karena mereka sama untuk semua subclass Dwelling.
*
* @param residents Jumlah penduduk saat ini
*/
abstract class Dwelling(private var residents: Int) {

    abstract val buildingMaterial: String
    abstract val capacity: Int

    /**
    * Memeriksa apakah ada ruang untuk penghuni lain.
    *
    * @return true jika kamar tersedia, false jika tidak
    */
    fun hasRoom(): Boolean {
        return residents < capacity
    }

    /**
    * Menghitung luas lantai hunian.
    * Diimplementasikan oleh subclass di mana bentuk ditentukan.
    *
    * @return area lantai
    */
    abstract fun floorArea(): Double

    /**
    * Membandingkan daya tampung dengan jumlah penduduk dan
    * jika daya tampung lebih besar dari jumlah penduduk
    * tambah penduduk dengan menambah jumlah penduduk.
    * Cetak hasilnya.
    */
    fun getRoom() {
        if (capacity > residents) {
            residents++
            println("You got a room!")
        } else {
            println("Sorry, at capacity and no rooms left.")
        }
    }
}

/**
* Sebuah hunian kabin persegi.
*
*  @param residents Jumlah penduduk saat ini
*  @param length Panjang
*/
class SquareCabin(
    residents: Int,
    val length: Double) : Dwelling(residents) {

    override val buildingMaterial = "Wood"
    override val capacity = 6

    /**
    * Menghitung luas lantai untuk hunian persegi.
    *
    * @return area lantai
    */
    override fun floorArea(): Double {
        return length * length
    }
}

/**
* Hunian dengan luas lantai melingkar
*
* @param residents Jumlah penduduk saat ini
* @param radius Radius
*/
open class RoundHut(
    val residents: Int,
    val radius: Double) : Dwelling(residents) {

    override val buildingMaterial = "Straw"
    override val capacity = 4

    /**
    * Menghitung luas lantai untuk hunian bulat
    *
    * @return area lantai
    */
    override fun floorArea(): Double {
        return PI * radius * radius
    }

    /**
    *  Menghitung panjang maksimal untuk karpet persegi
    *  yang sesuai dengan lantai melingkar.
    *
    * @return panjang karpet
    */
    fun calculateMaxCarpetSize(): Double {
        val diameter = 2 * radius
        return sqrt(diameter * diameter / 2)
    }
}

/**
* Menara bundar dengan banyak lantai.
*
* @param residents Jumlah penduduk saat ini
* @param radius Radius
* @param floors Jumlah lantai
*/
class RoundTower(
    residents: Int,
    radius: Double,
    val floors: Int = 2) : RoundHut(residents, radius) {

    override val buildingMaterial = "Stone"

    // Kapasitas tergantung pada jumlah lantai.
    override val capacity = 4 * floors

    /**
    * Menghitung total luas lantai untuk hunian menara
    * dengan banyak lantai.
    *
    * @return area lantai
    */
    override fun floorArea(): Double {
        return super.floorArea() * floors
    }
}