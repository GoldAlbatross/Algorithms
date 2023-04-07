package trash.sorts



fun main() {
    val list = mutableListOf(64, 42, 73, 41, 31, 53, 16, 24, 57, 42, 74, 55, 36)

    var sorted = false
    while (!sorted) {
        sorted = true
        for (i in list.lastIndex downTo 1) {
            if (list[i] > list[i-1]) {
                val max = list[i-1]
                list[i-1] = list[i]
                list[i] = max
                sorted = false
            }
        }
    }

    println(list)
}