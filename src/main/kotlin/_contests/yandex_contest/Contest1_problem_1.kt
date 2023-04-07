package _contests.yandex_contest

import java.io.File
import java.io.PrintWriter
import java.util.Scanner


fun main() {
    val t = System.currentTimeMillis()

    val input = "input.txt"
    val output = "output.txt"
    val scn = Scanner(File(input))
    val out = PrintWriter(output)

    val groups = MutableList(scn.nextInt()) {scn.nextInt()}
    reversSort(groups)
    println("groups -> ${groups.size}")

    val houses = ArrayList<Int>()
    (1..scn.nextInt()).forEach { _ ->
        val item = scn.nextInt()
        repeat(scn.nextInt()) { houses.add(item) }
    }
    reversSort(houses)
    println("houses -> ${houses.size}")


    out.use {
        if (groups.size <= houses.size) it.print(subtract(groups, houses))
        else it.print("No")
    }

    println(System.currentTimeMillis() - t)
    val memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
    println(memory / 1024)

}

fun reversSort(list: MutableList<Int>) {
    var gap = list.lastIndex

    var sorted = false
    while (!sorted && gap !=1) {

        sorted = true
        gap = if (gap > 1) gap * 10 / 13 else 1
        for (i in list.lastIndex downTo gap) {

            if (list[i] > list[i - gap]) {
                val max = list[i - gap]
                list[i - gap] = list[i]
                list[i] = max
                sorted = false
            }
        }
    }
}

fun subtract(groups: MutableList<Int>, houses: ArrayList<Int>): String {
    (groups.indices).forEachIndexed { index, _ ->
        if (houses[index] - groups[index] < 0)
            return "No"
    }
    return "Yes"
}

