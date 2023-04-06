package trash.sorts


fun main() {
    val t = System.currentTimeMillis()

    val list = List(10) {it+1}.shuffled().toMutableList()
    println("\nlist")
    println("========================================")
    bSort(list)


    val memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
    println("${memory/1024}")

    val time = System.currentTimeMillis() - t
    println(time)


}

fun bSort(list: MutableList<Int>): MutableList<Int> {
    var gap = list.lastIndex

    var sorted = false
    while (!sorted && gap !=1) {

        sorted = true
        gap = if (gap > 1) gap * 10 / 13 else 1
        for (i in gap..list.lastIndex) {
            println("gap=$gap -> $list")
            println("if(${list[i-gap]} > ${list[i]})\n")

            if (list[i-gap] > list[i]) {
                val min = list[i]
                list[i] = list[i-gap]
                list[i-gap] = min
                sorted = false
            }
        }
    }
    return list
}
