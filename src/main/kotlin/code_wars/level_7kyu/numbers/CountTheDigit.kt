package code_wars.level_7kyu.numbers
/*
все числа от 0 до n возвести в квадрат и найти в результатах число d
 */

fun main() {
    println(nbDig(5750, 0))
    println(nbDig1(5750, 0))
    println(nbDig2(5750, 0))

}
//----------------------------------------------------------------------------------------------------------------------
fun nbDig(n:Int, d:Int): Int =
    List(n+1) { it * it }
        .filter { it.toString().contains("$d") }
        .joinToString ("")
        .count { it.digitToInt() == d }
//----------------------------------------------------------------------------------------------------------------------
fun nbDig1(n: Int, d: Int): Int =
    (0..n)
        .joinToString { "${it * it}" }
        .count { "$it" == "$d" }
//----------------------------------------------------------------------------------------------------------------------
fun nbDig2(n:Int, d:Int) =
    (0..n)
        .sumOf { (it * it).toString().count { it == Character.forDigit(d, 10) } }
//----------------------------------------------------------------------------------------------------------------------

