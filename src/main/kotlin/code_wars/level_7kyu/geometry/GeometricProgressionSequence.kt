package code_wars.level_7kyu.geometry
/*
написать геометрическую прогрессию
 */

import kotlin.math.pow

fun main() {
    println(geometricSequenceElements(2, -3, 40))
    println(geometricSequenceElements1(2, -3, 50))
    println(geometricSequenceElements2(2, -3, 40))
}
//----------------------------------------------------------------------------------------------------------------------
fun geometricSequenceElements(a: Int, r: Int, n: Int): String {
    val list = StringBuilder("$a")
    for (i in 1 until n) {
        var letter = (a * r.toDouble().pow(i).toInt()).toString()
        list.append(", ", letter)
    }
    return list.toString()
}
//----------------------------------------------------------------------------------------------------------------------
fun geometricSequenceElements1(a: Int, r: Int, n: Int): String =
    generateSequence(a) { it * r }
        .take(n)
        .joinToString(", ")
//----------------------------------------------------------------------------------------------------------------------
fun geometricSequenceElements2(a: Int, r: Int, n: Int ): String = when {
    n > 1 -> "$a, ${geometricSequenceElements(a * r, r, n - 1)}"
    n == 1 ->"$a"
    else -> ""
}
