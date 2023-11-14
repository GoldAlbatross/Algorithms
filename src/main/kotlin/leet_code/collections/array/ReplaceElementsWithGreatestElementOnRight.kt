package leet_code.collections.array

fun main() {
    println(replaceElements(intArrayOf(17,18,5,4,6,1)))
}

fun replaceElements(arr: IntArray): IntArray {

    var max = -1
    var temp = 0
    val n = arr.lastIndex

    for (i in n downTo 0) {
        temp = arr[i]
        arr[i] = max
        if (temp > max) {
            max = temp
        }
    }
    return arr
}