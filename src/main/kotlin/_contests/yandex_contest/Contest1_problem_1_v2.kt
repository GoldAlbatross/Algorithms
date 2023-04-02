package _contests.yandex_contest


import java.io.File
import java.io.PrintWriter
import java.util.Scanner


fun main() {
    val input = "input.txt"
    val output = "output.txt"
    val scn = Scanner(File(input))
    val out = PrintWriter(output)


    val groups = ArrayList<Int>()
    (1..scn.nextInt()).forEach { _ -> groups.add(scn.nextInt()) }
    println("groups -> $groups")


    val map = HashMap<Int,Int>()
    (1..scn.nextInt()).forEach { _ ->
        val key = scn.nextInt()
        if (map[key] == null) map[key] = scn.nextInt()
        else map[key] = scn.nextInt() + map[key]!!
    }
    println("houses -> $map\n")


    val groups2 = ArrayList<Int>()

    groups.forEach {
        if (map.containsKey(it)) {
            if (map[it]!! > 0)
                map[it] = map[it]!! - 1
            else map.remove(it)!!
        }
        else groups2.add(it)
    }

    val h = ArrayList<Int>()
    map.forEach { (t, u) ->
        repeat(u) {h.add(t)}
    }

    reversSort1(groups2)
    reversSort1(h)

    println("groups2 -> $groups2")
    println("map -> $map")
    println("h -> $h")



    out.use {
        if (groups.size <= h.size) it.print(subtract1(groups2, h))
        else it.print("No")
    }

    val memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
    println(memory)
    // 6,57566   6104664   4662496   4783984
}

fun reversSort1(list: ArrayList<Int>) {
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

fun subtract1(groups: ArrayList<Int>, houses: ArrayList<Int>): String {
    (groups.indices).forEachIndexed { index, _ ->
        if (houses[index] - groups[index] < 0)
            return "No"
    }
    return "Yes"
}

