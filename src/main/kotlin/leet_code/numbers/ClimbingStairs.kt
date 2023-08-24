package leet_code.numbers

/*
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
private fun main() {
    println(climbStairs(3))
}

fun climbStairs(n: Int): Int {
    if (n <= 1) return n

    var first = 0
    var second = 1
    var result = 0

    for (i in 2..n) {
        result = first + second
        first = second
        second = result
    }

    return result
}
