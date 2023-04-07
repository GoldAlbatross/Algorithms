package trash.sorts


fun main() {
    val t = System.currentTimeMillis()

    val list = List(10) {it+1}.shuffled().toMutableList()
    println("\nlist")
    println("========================================")
    reversComb(list)


    val memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
    println("${memory/1024}")

    val time = System.currentTimeMillis() - t
    println(time)


}

fun reversComb(list: MutableList<Int>): MutableList<Int> {
    var gap = list.lastIndex

    var sorted = false
    while (!sorted && gap !=1) {

        sorted = true
        gap = if (gap > 1) gap * 10 / 13 else 1
        for (i in list.lastIndex downTo gap) {
            println("gap=$gap -> $list")
            println("if(${list[i]} > ${list[i-gap]})\n")

            if (list[i] > list[i-gap]) {
                val max = list[i-gap]
                list[i-gap] = list[i]
                list[i] = max
                sorted = false
            }
        }
    }
    println(list)
    return list
}
