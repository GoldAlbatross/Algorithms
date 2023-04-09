package _contests.yandex_contest


import java.io.File
import java.io.PrintWriter
import java.util.Scanner


fun main() {
//    val t = System.currentTimeMillis()

    val input = "input.txt"
    val output = "output.txt"
    val scn = Scanner(File(input))
    val out = PrintWriter(output)


    val capacity = scn.nextInt()
    val groups = MutableList(capacity) { scn.nextInt() }
        .groupingBy { it }
        .eachCount()
        .toMutableMap()

    val houses = HashMap<Int, Int>(capacity)
    repeat(scn.nextInt()) {
        val key = scn.nextInt()
        if (houses[key] == null) houses[key] = scn.nextInt()
        else houses[key] = scn.nextInt() + houses[key]!!
    }

    val groupKeys = ArrayList<Int>(groups.size)
    groups.forEach { groupKeys.add(it.key) }
    revers(groupKeys)

    val housesKeys = ArrayList<Int>(houses.size)
    houses.forEach { housesKeys.add(it.key) }
    revers(housesKeys)

    for (g in groupKeys) {
        if (houses.size != 0) {
            var h = housesKeys[0]
            if (g <= housesKeys[0]) {
                if (groups[g]!! > houses[h]!!) {
                    while (groups[g]!! > houses[h]!!) {
                        groups[g] = groups[g]!! - houses[h]!!
                        houses.remove(h)
                        housesKeys.remove(h)
                        h = housesKeys[0]
                    }
                }
                if (houses[h]!! == groups[g]!!) {
                    groups.remove(g)
                    houses.remove(h)
                    housesKeys.remove(h)
                } else if (groups[g]!! < houses[h]!!) {
                    houses[h] = houses[h]!! - groups[g]!!
                    groups.remove(g)
                }

//                println("groups -> ${groups.size}")
//                println("houses -> ${houses.size}")
//                println("========================")
            } else out.use { it.print("No") }
        } else out.use { it.print("No") }
    }
    out.use { it.print("Yes") }


//    println(System.currentTimeMillis() - t)
//    val memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
//    println(memory / 1024)
}

fun revers(list: MutableList<Int>) {
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


