package trash

fun main() {
    val arr = intArrayOf(1,8,2,3,4,5)
    val x = 4


    println(getMaxElements(arr,x).contentToString())
}


fun getMaxElements(arr: IntArray, numbersOfMaxElements: Int): IntArray {
    val maxElements = IntArray(numbersOfMaxElements)
    var previousMaxElements = Int.MAX_VALUE
    for (i in 0 until numbersOfMaxElements) {
        var currentMax = Int.MIN_VALUE
        for (j in arr.indices) {
            if (arr[j] < previousMaxElements)
                currentMax =
                    if (currentMax >= arr[j]) currentMax
                    else arr[j]
        }
        previousMaxElements = currentMax
        maxElements[i] = currentMax
    }
    return maxElements
}