package interview.sorts



fun main() {
    val list = mutableListOf(64, 42, 73, 41, 31, 53, 16, 24, 57, 42, 74, 55, 36)

    var isSorted = false
    while (!isSorted) {
        isSorted = true
        for (i in (list.lastIndex-1)downTo 0) {
            if (list[i+1] > list[i]) {
                val temp = list[i]
                list[i] = list[i+1]
                list[i+1] = temp
                isSorted = false
            }
        }
    }

    println(list)
}