package _contests.yandex_contest.second


import java.io.File
import java.io.PrintWriter
import java.util.*

fun main() {
    val sc = Scanner(File("input.txt"))
    val out = PrintWriter("output.txt")
    val size = sc.nextInt()
    val intArr = IntArray(size) {sc.nextInt()}
    println(intArr.contentToString())

    var a = -1
    intArr.forEachIndexed { index, item -> if (a == -1 && item == 1) a = index+1 }

    var x = 0UL
    if (a == -1) x = (intArr.size * (intArr.size + 1) / 2).toULong()
    else {
        val lS = a-1
        val rS = intArr.size - a
        x = if (a == 1) ((rS * (rS+1) / 2)).toULong()
        else if (a == intArr.size) ((lS * (lS+1) / 2)).toULong()
        else (intArr.lastIndex * (intArr.lastIndex + 1) / 2).toULong()
    }

    out.print(x)
    out.close()
}











