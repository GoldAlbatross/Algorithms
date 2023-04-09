package _contests.yandex_contest.second

import java.io.File
import java.io.PrintWriter
import java.util.*

fun main() {
    val input = "input.txt"
    val output = "output.txt"
    val scn = Scanner(File(input))
    val out = PrintWriter(output)

    val time = scn.nextInt()
    val capacity = scn.nextInt()
    val list = MutableList(capacity) {scn.nextInt()}
    println("$list")


    var i = 0
    var maxSuccess = 0
    list.forEachIndexed { index, it ->
        if (it > time && it*(index+2) > maxSuccess) {
            maxSuccess = it*(index+2)
            i = index
        }
//        if (time*list.size > maxSuccess) {
//            maxSuccess = time*list.size
//            i = list.size
//        }
    }
    //println("max success -> $maxSuccess")


    list.add(i, time)
    println(list)
    println("${list.mapIndexed { index, it -> (index+1)*it }.sum()}")
}

// 23,23 строка +2 изменить на +1
// 26 строка убрать иф
// прибавить еденичку, затем прибавить иф