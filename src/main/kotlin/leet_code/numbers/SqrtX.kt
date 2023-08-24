package leet_code.numbers

import kotlin.math.abs

/*
Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
The returned integer should be non-negative as well.
You must not use any built-in exponent function or operator.
 */

private fun main() {
    println(mySqrt(8))
}
//======================================================================================================================
private fun mySqrt2(x: Int): Int {
    if (x == 0) return 0
    var left = 0
    var right = x/2+1

    while (left <= right) {
        val middle = (left + right)/2

        when {
            (x/middle == middle) -> return middle
            (x/middle > middle) -> left = middle+1
            (x/middle < middle) -> right = middle-1
        }
    }
    return right
}
//======================================================================================================================

private fun mySqrt(x: Int): Int {
    if (x == 0) return 0
    val eps = 0.00001

    var height = 1.0
    var width = x.toDouble()

    while (abs(width - height) > eps) {
        height = (height + width) / 2
        width = (x / height)
    }

    return height.toInt()
}