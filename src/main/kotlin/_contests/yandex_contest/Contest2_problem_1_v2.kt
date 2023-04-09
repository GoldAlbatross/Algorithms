package _contests.yandex_contest


import java.io.File
import java.io.PrintWriter
import java.util.*

fun main() {
    val input = "input.txt"
    val output = "output.txt"
    val scn = Scanner(File(input))
    val out = PrintWriter(output)

    var e = ""

    val a = scn.next().toBigInteger()
    val b = scn.next().toBigInteger()
    val c = scn.next().toBigInteger()

    e = when {
        (a > b && a < c) -> a.toString()
        (b > a && b < c) -> b.toString()
        (c > a && c < b) -> c.toString()
        (a < b && a > c) -> a.toString()
        (b < a && b > c) -> b.toString()
        (c < a && c > b) -> c.toString()
        (a == b || a == c) -> a.toString()
        (b == c) -> b.toString()
        else -> ""
    }

    out.use { it.print(e) }
}
