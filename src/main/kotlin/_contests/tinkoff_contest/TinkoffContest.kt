package trash.tinkoff_contest

//import java.util.Scanner
//
//fun main() {  // 100 10 12 1
//
//    var num = 0
//    val list = mutableListOf<Int>()
//    val scn = Scanner(System.`in`)
//
//    while (scn.hasNext()) {
//        list.add(scn.nextInt())
//    }
//
//    if (list[3] >= list[1])
//        num = list[0] + list[2] * (list[3] - list[1])
//    else
//        num = list[0]
//
//    println(num)
//}

//======================================================================================================================

//fun main() {  // 4  5  10
//
//    var num = 0
//    val scn = java.util.Scanner(System.`in`)
//    num = scn.nextInt()
//    var x = 1
//    var i = 0
//
//    while (x < num) {
//        x *= 2
//        i++
//    }
//
//    println(i)
//}



//======================================================================================================================

import java.util.Scanner
import kotlin.math.pow

fun main() {  // 5 2 1 881 1 918 998

    val scn = Scanner(System.`in`)
    val list = arrayListOf<Int>()
    val dif = arrayListOf<Pair<Int,Int>>()

    val str1 = scn.nextInt()
    val str2 = scn.nextInt()

    for (i in 0 until str1) {
        list.add(scn.nextInt())
        var a = list[i].toString().length
        a = (10.0).pow(a).toInt()
        dif.add(a - list[i] to list[i])
    }
    println("список значений ->$list")
    println("список разниц  -> $dif")


    var isSorted = false
    while (!isSorted) {
        isSorted = true
        for (i in (dif.lastIndex-1)downTo 0) {
            if (dif[i+1].first > dif[i].first) {
                val temp = dif[i]
                dif[i] = dif[i+1]
                dif[i+1] = temp
                isSorted = false
            }
        }
    }
   println("список разниц2  -> $dif")

    fun success() {

    }



//        dif[0] = dif[0].first to
//                if (dif[i].first >= dif[i].second) dif[i].first.toString().replace(Regex("[0-8]"), "9").toInt()
//                else dif[i].second.toString().replace(Regex("[0-8]"), "9").toInt()
//
//    println("список разниц3  -> $dif")


    val xxx = dif.map { it.second }.toList()
    var count = str2

//    while (count != 0) {
//        if (xxx[0].toString().length >= count)
//            if ()
//
//    }
    println(xxx)




}