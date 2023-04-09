package _contests.yandex_contest.second


import java.io.File
import java.io.PrintWriter
import java.util.*

fun main() {
    val input = "input.txt"
    val output = "output.txt"
    val scn = Scanner(File(input))
    val out = PrintWriter(output)

    var result = ""

    val a = scn.next().toBigInteger()
    val b = scn.next().toBigInteger()
    val c = scn.next().toBigInteger()

    result = when {
        (a > b && a < c) -> "$a"
        (b > a && b < c) -> "$b"
        (c > a && c < b) -> "$c"
        (a < b && a > c) -> "$a"
        (b < a && b > c) -> "$b"
        (c < a && c > b) -> "$c"
        (a == b || a == c) -> "$a"
        (b == c) -> "$b"
        else -> "Gag"
    }

    println(result)
    out.use { it.print(result) }
}
