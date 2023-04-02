package _contests.yandex_contest

import java.io.File
import java.io.PrintWriter
import java.util.Scanner


const val YES = "Yes"
const val NO = "Yes"
fun main() {
    val input = "input.txt"
    val output = "output.txt"
    val scn = Scanner(File(input))
    val out = PrintWriter(output)


    val groups = ArrayList<Short>()
    (1..scn.nextInt()).forEach { _ -> groups.add(scn.nextShort()) }
    reversSort(groups)
    println("houses -> $groups")


    val houses = ArrayList<Short>()
    (1..scn.nextInt()).forEach { _ ->
        val item = scn.nextShort()
        repeat(scn.nextInt()) { houses.add(item) }
    }
    reversSort(houses)
    println("houses -> $houses")


    out.use {
        if (groups.size <= houses.size) it.print(subtract(groups, houses))
        else it.print(NO)
    }

    val memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
    println(memory)
    // 6,57566   6104664   4662496
}

fun reversSort(list: ArrayList<Short>) {
    var sorted = false
    while (!sorted) {
        sorted = true
        for (i in (list.lastIndex-1)downTo 0) {
            if (list[i+1] > list[i]) {
                val temp = list[i]
                list[i] = list[i+1]
                list[i+1] = temp
                sorted = false
            }
        }
    }
}

fun subtract(groups: ArrayList<Short>, houses: ArrayList<Short>): String {
    (groups.indices).forEachIndexed { index, _ ->
        if (houses[index] - groups[index] < 0)
            return NO
    }
    return YES
}

