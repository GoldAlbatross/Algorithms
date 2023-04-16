package _contests.yandex_contest.first


import java.io.File
import java.io.PrintWriter
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val t = System.currentTimeMillis()

    val input = "input.txt"
    val output = "output.txt"
    val scn = Scanner(File(input))
    val out = PrintWriter(output)

    val count = scn.nextInt()
    val capacity = scn.nextInt()

    val citiesMap = ArrayList<Pair<Int,Int>>(capacity)
    repeat (capacity) { citiesMap.add(scn.nextInt() to scn.nextInt()) }

    val set = HashSet<Int>()
    citiesMap.forEach { set.add(it.second) }

//    println(citiesMap)
//    println(set)

// [(2, 9), (3, 8), (9, 4), (4, 8)]
// [4, 8, 9]
// 9 = (2,9)               | (3,8)                         -> set.delete(9)
// 8 = (2,9)->(9,4)->(4,8) | (3,8) | (9,4)->(4,8) | (4,8)  -> yes
// 4 = (2,9)->(9,4)        | (3,8)                         -> set.delete(4)



    if (set.size > 1) {
        val itr = set.iterator()

        while (itr.hasNext()) {
            val setItem = itr.next()


            for (item in citiesMap) {
                var match = true
                var finish = item.second


                while (setItem != finish) {
                    var fish = false

                    for (city in citiesMap) {
                        if (finish == city.first) {
                            finish = city.second
                            fish = true
                            break
                        }
                    }

                    if (fish && setItem == finish) {
                        match = false
                        break
                    }
                    if (!fish) {
                        itr.remove()
//                        println(set)
                        match = false
                        break
                    }
                }
                if (!match) break
            }
        }
    }
    if (set.size == 1) out.use { it.print("${set.average().toInt()}") }
    if (set.size == 0) out.use { it.print("-1") }

//    println(System.currentTimeMillis() - t)
//    val memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
//    println(memory / 1024)
}