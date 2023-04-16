package _contests.yandex_contest.second

import java.io.File
import java.io.PrintWriter
import java.util.*

fun main() {
    val input = "input.txt"
    val output = "output.txt"
    val scn = Scanner(File(input))
    val out = PrintWriter(output)

    val capacity = scn.nextInt()
    val a = IntArray(capacity) { scn.nextInt() }
    val b = IntArray(capacity) { scn.nextInt() }

    println(findIndices(a,b))
}

private fun findIndices(a: IntArray, b: IntArray): Int {
    val diff = IntArray(a.size) { a[it] - b[it] }
    val map = mutableMapOf<Int, Int>()
    map[0] = -1
    var sum = 0
    var maxDiff = -1
    for (i in diff.indices) {
        sum += diff[i]
        if (map.containsKey(sum) && i - map[sum]!! > maxDiff) {
            maxDiff = i - map[sum]!!
        }
        if (!map.containsKey(sum)) {
            map[sum] = i
        }
    }
    return maxDiff
}