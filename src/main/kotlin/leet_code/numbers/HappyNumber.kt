package leet_code.numbers

import kotlin.math.sqrt

/**
 * Write an algorithm to determine if a number n is happy.
 * A happy number is a number defined by the following process:
 *
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
*/
fun main() {
    println(isHappy(194))
}

fun isHappy(n: Int): Boolean {

    val set = mutableSetOf<Int>()

    var key = n

    while (key != 1 && !set.contains(key)) {
        set.add(key)
        var value = 0
        while(key > 0) {
            val dgt = key % 10
            value += dgt * dgt
            key /= 10
        }
        key = value
    }

    return key == 1

}
