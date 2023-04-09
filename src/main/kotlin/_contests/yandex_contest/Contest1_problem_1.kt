package _contests.yandex_contest

import java.io.File
import java.io.PrintWriter
import java.util.Scanner


fun main() {

    val input = "input.txt"
    val output = "output.txt"
    val scn = Scanner(File(input))
    val out = PrintWriter(output)

    val groups = MutableList(scn.nextInt()) {scn.nextShort()}

    val houses = mutableListOf<Short>()
    (1..scn.nextInt()).forEach { _ ->
        val item = scn.nextShort()
        repeat(scn.nextInt()) { houses.add(item) }
    }

    combReversSort(groups)
    combReversSort(houses)
    println("$groups\n$houses")

    out.use {
        if (groups.size <= houses.size) it.print(subtract(groups, houses))
        else it.print("No")
    }


}

fun combReversSort(list: MutableList<Short>) {
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

fun subtract(groups: MutableList<Short>, houses: MutableList<Short>): String {
    (groups.indices).forEachIndexed { index, _ ->
        if (houses[index] - groups[index] < 0)
            return "No"
    }
    return "Yes"
}

