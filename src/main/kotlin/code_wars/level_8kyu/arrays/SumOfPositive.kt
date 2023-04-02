package code_wars.level_8kyu.arrays
/*
Нужно получить сумму всех положительных чисел в массиве или 0.
 */

fun main() {
    println(sum(intArrayOf(-1, -2, -3, -4, -5)))
    println(sum1(intArrayOf(-1, -2, -3, -4, -5)))
    println(sum2(intArrayOf(-1, -2, -3, -4, -5)))
}

fun sum(numbers: IntArray): Int =
    numbers.sumOf { if (it >= 0) it else 0 }

fun sum1(numbers: IntArray) =
    numbers.filter { it > 0 }.sum()

fun sum2(numbers: IntArray) =
    numbers.sumOf { it.coerceAtLeast(0) }