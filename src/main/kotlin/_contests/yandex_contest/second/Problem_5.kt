package _contests.yandex_contest.second

import java.io.File
import java.io.PrintWriter
import java.util.Scanner
import kotlin.math.abs

fun main() {
    val scn = Scanner(File("input.txt"))
    val writer = PrintWriter(File("output.txt"))

    val n = scn.nextInt()
    val a = IntArray(n) { scn.nextInt() }
    val b = IntArray(n) { scn.nextInt() }

    var res =
        if (n < 2) 0
        else if (a.first() < a.last()) {
            if (b.first() < b.last()) {
                val diff = abs(a[0] - b[0])
                a.lastIndex - diff
            } else {
                val diff = abs(a.first() - b.last())
                a.lastIndex - diff
            }
        } else if (a.first() > a.last()) {
            if (b.first() > b.last()) {
                val diff = abs(a[0] - b[0])
                a.lastIndex - diff
            } else {
                val diff = abs(a.first() - b.last())
                a.lastIndex - diff
            }
        } else -1

    res = if (res < 0) -1 else res

    writer.use { it.print(res) }
}

