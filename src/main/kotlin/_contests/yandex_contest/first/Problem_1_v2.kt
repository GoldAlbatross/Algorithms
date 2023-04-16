package _contests.yandex_contest.first


import java.io.File
import java.io.PrintWriter
import java.util.Scanner


fun main() {
    val t = System.currentTimeMillis()

    val input = "input.txt"
    val output = "output.txt"
    val scn = Scanner(File(input))
    val out = PrintWriter(output)


    val capacity = scn.nextInt()
    val groups = ArrayList<Int>(capacity)
    repeat(capacity) { groups.add(scn.nextInt()) }


    val map = HashMap<Int,Int>(capacity)
    repeat(scn.nextInt()) {
        val key = scn.nextInt()
        if (map[key] == null) map[key] = scn.nextInt()
        else map[key] = scn.nextInt() + map[key]!!
    }

//    println("start groups -> ${groups}")
//    println("start map -> ${map}")
//    println("========================")



    val itr = groups.iterator()
    while (itr.hasNext()) {
        val it = itr.next()
        if (map.containsKey(it)) {
            map[it] = map[it]!! - 1
            itr.remove()
            if (map[it] == 0) map.remove(it)
        }
    }

    val houses = ArrayList<Int>()
    (map).forEach { itt ->
        repeat(itt.value) { houses.add(itt.key) }
    }


//    println("========================")
//    reversS(groups)
//    reversS(houses)
//    println("groups -> ${groups}")
//    println("houses -> ${houses}")



    out.use {
        if (groups.size <= houses.size) it.print(subtracting(groups, houses))
        else it.print("No")
    }




    println(System.currentTimeMillis() - t)
    val memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
    println(memory / 1024)
    // 6,57566   6104664   4662496   4783984   4796008   15805
}

fun reversS(list: MutableList<Int>) {
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

fun subtracting(groups: MutableList<Int>, houses: ArrayList<Int>): String {
    (groups.indices).forEachIndexed { index, _ ->
        if (houses[index] - groups[index] < 0)
            return "No"
    }
    return "Yes"
}


