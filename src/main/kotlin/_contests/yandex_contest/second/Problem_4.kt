package _contests.yandex_contest.second

import java.io.File
import java.io.PrintWriter
import java.util.*


// f(1)-2 = 0
// f(1,2,3)-4 = [2] [2,3] [3]
// f(2,3)-1 = [2] [2,3] [3]
// f(1,2,4)-3 = [1] [1,2] [2] [4]
// f(3,1,8,7,2) = [3] [8] [8,7] [8,7,2] [7] [7,2] ...

fun main() {
    val input = "input.txt"
    val output = "output.txt"
    val scn = Scanner(File(input))
    val out = PrintWriter(output)

    val capacity = scn.nextInt()
    val arr = IntArray(capacity) {scn.nextInt()}
    //val arr = IntArray(4) { (1..7).random() }
    println(arr.contentToString())
    var a = -1

    arr.forEachIndexed { index, item -> if (a == -1 && item == 1) a = index+1 }
    println(a)

    var x = 0UL
    if (a == -1) x = (arr.size * (arr.size + 1) / 2).toULong()
    else {
        val lS = a-1
        val rS = arr.size - a
        x = if (a == 1) ((rS * (rS+1) / 2)).toULong()
        else if (a == arr.size) ((lS * (lS+1) / 2)).toULong()
        else (arr.lastIndex * (arr.lastIndex + 1) / 2).toULong()
        println("$lS  $rS")

    }
    println(x)


    //out.use { it.print(countSubArrays(arr)) }
}











