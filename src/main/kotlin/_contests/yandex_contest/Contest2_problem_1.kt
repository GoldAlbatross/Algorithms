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
    val (a,b,c) = scn.nextLine().split(" ")
    val arr = arrayListOf(a, b, c).groupBy({it.length},{it}).toList()
    println("$a $b $c")
    println(arr)

    if (arr.size == 1) {
        e = getMiddleNum(a,b,c)
    }
    else if (arr.size == 3) {
        if (a.length > b.length && a.length < c.length) e = a
        if (b.length > a.length && b.length < c.length) e = b
        if (c.length > a.length && c.length < b.length) e = c
    }
    else if (arr.size == 2) {
        val (first,second) = arr.sortedByDescending { it.second.count() }[0].second
        val (third) = arr.sortedByDescending { it.second.count() }[1].second
        for (i in 0..first.lastIndex) {

            if (first[i] > second[i]) {
                e = if (first.length < third.length) first else second
                break
            }
            if (second[i] > first[i]) {
                e = if (second.length < third.length) second else first
                break
            }
        }
        if (e.isEmpty()) e = first
    }

    println(e)
    out.use { it.print(e) }
}
fun getMiddleNum(a: String, b: String, c: String):String {

    for (i in 0..a.lastIndex) {
        if (a[i] > b[i]) {
            for (j in 0..c.lastIndex) {
                if (a[j] < c[j]) return a // b<a>c
            }
            return a
        }
    }
    for (i in 0..a.lastIndex) {
        if (b[i] > a[i]) {
            for (j in 0..c.lastIndex) {
                if (b[j] < c[j]) return b // a<b>c
            }
            return b
        }
    }
    for (i in 0..a.lastIndex) {
        if (c[i] > a[i]) {
            for (j in 0..c.lastIndex) {
                if (c[j] < b[j]) return c // a<c>b
            }
            return c
        }
    }
    return a
}