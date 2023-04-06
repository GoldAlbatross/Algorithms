package _contests.yandex_contest

import java.io.File
import java.io.PrintWriter
import java.util.*
import kotlin.collections.HashMap

fun main() {

    val input = "input.txt"
    val output = "output.txt"
    val scn = Scanner(File(input))
    val out = PrintWriter(output)

    val count = scn.nextInt()
    val capacity = scn.nextInt()

    val citiesMap = HashMap<Int,Int>(capacity)
    repeat (capacity) { citiesMap[scn.nextInt()] = scn.nextInt() }

    val set = HashSet<Int>()
    set.addAll(citiesMap.values)

    println(citiesMap)
    println(set)

    if (set.size > 1) {
        val itr = set.iterator()
        while (itr.hasNext()) {
            val it = itr.next()
            for (k in citiesMap.keys) {
                if (it != citiesMap[k]) {
                    var key = citiesMap[k]
                    while (citiesMap[key] != null && citiesMap[key] != it) {
                        key = citiesMap[key]!!
                    }
                    if (citiesMap[key] != it) {
                        itr.remove()
                        break
                    }
                    println(set)
                }
            }
        }
    }
    if (set.size == 1) out.use { it.print("${set.toArray()[0]}") }
    else out.use { it.print("-1") }

    println(set)
}