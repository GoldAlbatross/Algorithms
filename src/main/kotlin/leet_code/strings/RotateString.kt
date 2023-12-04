package leet_code.strings

/**
 * Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
 * A shift on s consists of moving the leftmost character of s to the rightmost position.
 * For example, if s = "abcde", then it will be "bcdea" after one shift.
 *
 *
 * Example 1:
 * Input: s = "abcde", goal = "cdeab"
 * Output: true
 *
 * Example 2:
 * Input: s = "abcde", goal = "abced"
 * Output: false
 * */

fun main() {
    println(rotateString("abcde", "cdeab"))
}

fun rotateString(s: String, goal: String): Boolean {
    val listIndex = arrayListOf<Int>()
    val listStr = arrayListOf<String>()
    if (s.length != goal.length) return false

    for (i in 0..s.lastIndex) {
        if (s[i] == goal[0]) {
            listIndex.add(i)
        }
    }

    listIndex.forEach {
        listStr.add(s.substring(it, s.length) + s.take(it))
    }

    return goal in listStr
}