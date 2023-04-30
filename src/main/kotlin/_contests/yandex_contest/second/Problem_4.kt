package _contests.yandex_contest.second


import java.io.File
import java.io.PrintWriter
import java.util.Scanner

fun main() {
    val scn = Scanner(File("input.txt"))
    val writer = PrintWriter("output.txt")

    val c = scn.nextInt()
    val arr = IntArray(c) { scn.nextInt() }

    var res = 0UL
    var size = 0
    arr.forEach {
        if (it != 1) ++size
        else {
            res += (size * (size+1) / 2).toULong()
            size = 0
        }

    }
    res += (size * (size+1) / 2).toULong()
    writer.use { it.print(res) }
}











