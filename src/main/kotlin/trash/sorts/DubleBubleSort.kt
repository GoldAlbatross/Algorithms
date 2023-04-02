package trash.sorts

fun main() {
    val list = mutableListOf(42, 64, 73, 31, 53, 24, 82, 36, 13, 57, 35, 1, 54)


//    var count = 0
//    println("%04d".format(0) + " -> $list")

    var sub = 0
    var sorted = false
    while (!sorted) {
        sorted = true

        val left = 0 + sub
        val right = list.lastIndex - 1 - sub++
        for (i in right downTo left) {

            if (list[i] < list[i+1]) {
                val max = list[i+1]
                list[i+1] = list[i]
                list[i] = max
                sorted = false
            }

            val rightIndex = list.lastIndex-i
            if (list[rightIndex-1] < list[rightIndex]) {
                val min = list[rightIndex-1]
                list[rightIndex-1] = list[rightIndex]
                list[rightIndex] = min
                sorted = false
            }
            //println("%04d".format(++count) + " -> $list")
        }
        //println("=================================================")
    }
}