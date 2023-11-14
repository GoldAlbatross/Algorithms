package leet_code.collections.array
/**
 * Given four integers length, width, height, and mass, representing the dimensions and mass of a box, respectively, return a string representing the category of the box.
 *
 * The box is "Bulky" if:
 * Any of the dimensions of the box is greater or equal to 104.
 * Or, the volume of the box is greater or equal to 109.
 * If the mass of the box is greater or equal to 100, it is "Heavy".
 * If the box is both "Bulky" and "Heavy", then its category is "Both".
 * If the box is neither "Bulky" nor "Heavy", then its category is "Neither".
 * If the box is "Bulky" but not "Heavy", then its category is "Bulky".
 * If the box is "Heavy" but not "Bulky", then its category is "Heavy".
 * Note that the volume of the box is the product of its length, width and height.
 * */
fun main() {
    println(categorizeBox(2909,3968, 3272, 727))
}

fun categorizeBox(length: Int, width: Int, height: Int, mass: Int): String {
    val list = mutableListOf("", "", "")
    val l = length.toLong()
    val w = width.toLong()
    val h = height.toLong()

    if (l >= 10000L || w >= 10000L || h >= 10000L || w * h * l >= 1000000000L) {
        list[0] = "Bulky"
    }

    if (mass >= 100) {
        list[1] = "Heavy"
    }

    if (list[0] == "Bulky" && list[1] == "Heavy") {
        return "Both"
    }

    if (list[0] == "" && list[1] == "") {
        return "Neither"
    }

    var result = ""

    list.forEach { if (it.isNotEmpty()) result = it }
    return result

}