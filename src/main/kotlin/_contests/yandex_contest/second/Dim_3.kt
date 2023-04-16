package _contests.yandex_contest.second

import java.io.File
import java.io.PrintWriter
import java.util.*

fun main() {
    val sc = Scanner(File("input.txt"))
    val out = PrintWriter("output.txt")

    val t = sc.nextInt()
    val size = sc.nextInt()
    val intArr = IntArray(size) {sc.nextInt()}

    var l = 0L
    val ans = sum(intArr)
    var r = ans.second
    var res = (t*1L) + r

    for (i in 1..intArr.size) {
        l += intArr[i-1] * i
        val curTime = t * (i+1)
        r -= intArr[i-1] * (i+1)
        val temp = l + curTime + r
        if (temp > res) {
            res = temp
        }
    }
    out.print(res - ans.first)
    out.close()
}

fun sum(list: IntArray): Pair<Long,Long> {
    var sum = 0L
    var sum2 = 0L
    for (i in list.indices) {
        sum += list[i] * (i+1)
        sum2 += list[i] * (i+2)
    }
    return Pair(sum,sum2)
}

