package code_wars.level_8kyu.arrays

import kotlin.math.pow

/*
Complete the square sum function so that it squares each number passed into it and then sums the results together.
 */

fun main() {
    println(squareSum(arrayOf(1, 2)))
    println(squareSum1(arrayOf(1, 2)))
}

fun squareSum(n: Array<Int>): Int =
    n.sumOf { it.toDouble().pow(2).toInt() }
//----------------------------------------------------------------------------------------------------------------------
fun squareSum1(n: Array<Int>) =
    n.sumOf { it * it }
