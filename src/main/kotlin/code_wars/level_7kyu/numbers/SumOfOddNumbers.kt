package code_wars.level_7kyu.numbers

import kotlin.math.pow
/*
найти сумму в н-ной строке треугольника состоящего из odd numbers
 */
fun main() {
    println(rowSumOddNumbers(13))
    println(rowSumOddNumbers1(13))
    println(rowSumOddNumbers2(13))
}

fun rowSumOddNumbers(n: Int): Int {
    var result = 1
    if (n > 1) {
        result = ((n-1) *n +1) *n
        result += (1 until n).sumOf { it*2 }
    }
    return result
}

fun rowSumOddNumbers1(n: Int): Int =
    n * n * n

fun rowSumOddNumbers2(n: Int): Int =
    n.toDouble().pow(3.0).toInt()