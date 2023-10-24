package trash.memory

fun main() {
    val startTime = System.currentTimeMillis()

//    val list = IntArray(100_000_000) { it % (1..9).random() }
//    list[0] = 80

    val list = IntArray(100_000_000) { it % (1..9).random() }
    for (i in 0..1000000 step (0..9).random()) {
        list[i] = 0
    }
    println(list.count { it in 8..23 })

    checkPerformance(startTime)
}

fun checkPerformance(startTime: Long) {
    println("${System.currentTimeMillis() - startTime}ms")
    val memory = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024
    println("${memory}Kb")
}


//time: 1663ms,  memory: 399759Kb
// 767          speed     IntArray
// 402 878      memory

// 3005         speed     Array
// 1 879 042    memory