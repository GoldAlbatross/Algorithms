package trash.memory

import java.util.concurrent.atomic.AtomicInteger

inline fun checkPerformanceWithInline(actionBlock: () -> Unit) {
    val startTime = System.currentTimeMillis()
    val runtime = Runtime.getRuntime()
    actionBlock()
    val endTime = System.currentTimeMillis() - startTime
    val memory = runtime.totalMemory() - runtime.freeMemory()
    println("time: ${endTime}ms,  memory: ${memory / 1024}Kb")
}

fun main() {

    checkPerformanceWithInline {
        val list = Array<Any?>(100_000_000) { (it * 3) % (1..13).random() }
        for (i in 0..1000000 step (1..9).random()) {
            list[i] = null
        }
        println(list.count { it in 8..23 })
    }
}

// IntArray    = time: 777ms,  memory: 399353Kb
//val list = IntArray(100_000_000) { (it * 3) % (1..13).random() }
//for (i in 0..1000000 step (1..9).random()) {
//    list[i] = 4
//}
//println(list.count { it in 8..23 })


// Array<Int?> = time: 1460ms, memory: 404510Kb
//val list = Array<Int?>(100_000_000) { (it * 3) % (1..13).random() }
//for (i in 0..1000000 step (1..9).random()) {
//    list[i] = null
//}
//println(list.count { it in 8..23 })


// MutableList<Int?> = time: 2260ms,  memory: 402984Kb
//val list = MutableList<Int?>(100_000_000) { (it * 3) % (1..13).random() }
//for (i in 0..1000000 step (1..9).random()) {
//    list[i] = null
//}
//println(list.count { it in 8..23 })