package trash.memory

fun main() {
    val startTime = System.currentTimeMillis()

//    val list = IntArray(100_000_000) { it % (1..9).random() }
//    list[0] = 80

    val list = Array<Int?>(100_000_000) { it % (1..9).random() }
    list[0] = null

    println(list.count { it == 8 })

    checkPerformance(startTime)
}

fun checkPerformance(startTime: Long) {
    println(System.currentTimeMillis() - startTime)
    val memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
    println(memory / 1024)
}
// 767          speed     IntArray
// 402 878      memory

// 3005         speed     Array
// 1 879 042    memory