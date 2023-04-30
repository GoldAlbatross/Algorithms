package _contests.yandex_contest.second

import java.io.File
import java.io.PrintWriter
import java.util.Scanner

fun main() {

    val scn = Scanner(File("input.txt"))
    val writer = PrintWriter(File("output.txt"))

    val(a,b,c) = scn.nextLine().split(" ").map { it.toBigInteger() }

    val result = when {
        (a > b && a < c) -> a
        (a < b && a > c) -> a
        (b > a && b < c) -> b
        (b < a && b > c) -> b
        (c > a && c < b) -> c
        (c < a && c > b) -> c
        (a == b || a == c) -> a
        else -> b
    }

    writer.use { it.print(result.toString()) }
}
