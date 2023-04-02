package interview

import kotlin.math.abs
import kotlin.math.log10


fun main() {
    val str = "How are you"
    println( str.getListOfWords() )
    println( str.firstWord )
    println((-123).lengthNumber())
}


//======================================================================================== Int =========================
fun Int.lengthNumber() = when(this) {
    0 -> 1
    else -> log10(abs(toDouble())).toInt() + 1
}


//======================================================================================== String ======================
val String.firstWord: String
    get() = this.takeWhile { it != ' ' }

fun String.getListOfWords():List<String> =
    this.split( " ")






