package leet_code.collections.array

fun main() {
    println(trimMean(intArrayOf(6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0)))
}

fun trimMean(arr: IntArray): Double {
    val stock = arrayListOf<Int>()
    var max = Int.MIN_VALUE
    var min = Int.MAX_VALUE

    repeat(arr.size/20) {
        for (i in 0..arr.lastIndex) {
            if (arr[i] >= max)
                max = arr[i]
            if (arr[i] <= min)
                min = arr[i]
        }
        stock.add(min)
        stock.add(max)

        println(stock)
    }

    val sum = arr.sum()
    val stockSum = stock.sum()
    val size = arr.size * 0.9
    println("sum:$sum  stockSum:$stockSum  size:$size")

    return (sum - stockSum) / (arr.size * 0.9)
}