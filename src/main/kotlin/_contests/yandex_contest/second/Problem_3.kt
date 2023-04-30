package _contests.yandex_contest.second

import java.io.File
import java.io.PrintWriter
import java.util.Scanner

fun main() {
    val scn = Scanner(File("input.txt"))
    val writer = PrintWriter(File("output.txt"))

    val k = scn.nextInt()
    val n = scn.nextInt()
    val arr = IntArray(n) { scn.nextInt() }

    var left = 0L
    val ans = sum(arr)
    var right = ans.second
    var res = (k * 1L) + right

    for (i in 1..arr.size) {
        left += arr[i-1] * i
        val curTime = k * (i+1)
        right -= arr[i-1] * (i+1)
        val temp = left + curTime + right
        if (temp > res) {
            res = temp
        }
    }
    writer.use { it.print(res - ans.first) }
}

private fun sum(list: IntArray): Pair<Long,Long> {
    var sum = 0L
    var sum2 = 0L
    for (i in list.indices) {
        sum += list[i] * (i+1)
        sum2 += list[i] * (i+2)
    }
    return Pair(sum,sum2)
}

