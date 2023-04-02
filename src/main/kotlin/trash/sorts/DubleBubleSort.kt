package trash.sorts

fun main() {
    val list = mutableListOf(42, 64, 73, 31, 53, 24, 82, 36, 13, 57, 35, 1, 54)

    var count = 0
    println("%04d".format(0) + " -> $list")

    var sorted = false
    var left = 0
    var right = list.lastIndex - 1

    while (!sorted) {
        sorted = true
        for (i in right downTo left) {

            if (list[i] < list[i+1]) {
                val max = list[i+1]
                list[i+1] = list[i]
                list[i] = max
                sorted = false
            }

            val j = list.lastIndex - i
            if (list[j-1] < list[j]) {
                val min = list[j-1]
                list[j-1] = list[j]
                list[j] = min
                sorted = false
            }
            println("%04d".format(++count) + " -> $list")
        }
        right--
        left++
        println("=================================================")
    }
}