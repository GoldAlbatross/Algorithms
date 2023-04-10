package _contests.yandex_contest.second

import java.io.File
import java.io.PrintWriter
import java.util.*

fun main() {
    val input = "input.txt"
    val output = "output.txt"
    val scn = Scanner(File(input))
    val out = PrintWriter(output)

    val time = scn.nextShort()
    val capacity = scn.nextInt()
    val list = ShortArray(capacity) {scn.nextShort()}
    println(list.contentToString())
    val x = list.toMutableList()

    var result = 0
    var i = 0
    var maxSuccess = 0
    list.forEachIndexed { index, it ->
        //print("${it*(index+2)}->")
        if (it > time && it * (index+2) > maxSuccess) {
            maxSuccess = it * (index+2)
            i = index
        }
    }

    if (time * (list.size+1) > maxSuccess) {
        list.forEachIndexed { index, it -> result += it * (index+1) }
        result += time * (list.size+1)
    }
    else {
        list.forEachIndexed { index, it ->
            if (index < i) { result += it * (index+1) }
            if (index >= i) { result += it * (index+2) }
        }
        result += time * (i+1)
    }

    if (i == 0) x.add(x.size, time) else x.add(i,time)

    println("$i $maxSuccess $x")
    println("$result")
    out.use { it.print(maxSuccess) }
}

// 23,23 строка +2 изменить на +1
// 26 строка убрать иф
// прибавить еденичку, затем прибавить иф