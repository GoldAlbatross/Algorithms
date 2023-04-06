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


    val capacity = scn.nextInt()
    val groups = ArrayList<Int>(capacity)
    repeat(capacity) { groups.add(scn.nextInt()) }


    val map = HashMap<Int,Int>(capacity)
    repeat(scn.nextInt()) {
        val key = scn.nextInt()
        if (map[key] == null) map[key] = scn.nextInt()
        else map[key] = scn.nextInt() + map[key]!!
    }

    println("start groups -> ${groups}")
    println("start map -> ${map.size}")
    println("========================")



    var itr = groups.iterator()
    while (itr.hasNext()) {
        val it = itr.next()
        if (map.containsKey(it)) {
            map[it] = map[it]!! - 1
            itr.remove()
            if (map[it] == 0) map.remove(it)
        }
    }

    println("groups -> ${groups.size}")
    println("map -> ${map.size}")
    println("========================")
    bubbleSort(groups)


    var ok = false
    while (!ok) {
        ok = true
        itr = map.keys.iterator()
        while (itr.hasNext()) {
            val it = itr.next()
            if (groups.last() <= it) {
                map[it] = map[it]!! - 1
                itr.remove()
                groups.remove(groups.last())
                if (map[it] == 0) map.remove(it)
                ok = false
            }
        }
        if (groups.size == 0) {
            println("Yes")
            out.use { it.print("Yes")
            }
            ok = true
        }
        println("========================")
        println("groups -> ${groups.size}")
        println("map -> ${map.size}")
    }

    println("No")
    out.use { it.println("No") }




    println(System.currentTimeMillis() - t)
    val memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
    println(memory / 1024)
    // 6,57566   6104664   4662496   4783984   4796008   15805
}

fun bubbleSort(arr: ArrayList<Int>) {
    var sorted = false
    while (!sorted) {
        sorted = true
        for (i in 1..arr.lastIndex) {
            if (arr[i - 1] > arr[i]) {
                val temp1 = arr[i]
                arr[i] = arr[i - 1]
                arr[i - 1] = temp1
                sorted = false
            }
        }
    }
}


