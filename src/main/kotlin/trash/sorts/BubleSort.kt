package interview.sorts



fun main() {
    val arr = mutableListOf(64, 42, 73, 41, 31, 53, 16, 24, 57, 42, 74, 55, 36)

    var isSorted = false
    while (!isSorted) {
        isSorted = true
        for (i in 1..arr.lastIndex) {
            if (arr[i - 1] > arr[i]) {
                val temp1 = arr[i]
                arr[i] = arr[i - 1]
                arr[i - 1] = temp1
                isSorted = false
            }
        }
    }

    println(arr)
}