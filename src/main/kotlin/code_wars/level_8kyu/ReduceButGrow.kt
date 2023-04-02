package code_wars.level_8kyu

fun main() {
    println(grow(intArrayOf(2,3,4)))
    println(grow1(intArrayOf(2,3,4)))
    println(grow2(intArrayOf(2,3,4)))
    println(grow3(intArrayOf(2,3,4)))
}

fun grow(arr: IntArray): Int =
    arr.fold(1) {acc, i -> acc * i}

fun grow1(arr: IntArray): Int =
    arr.reduce { acc, i -> acc * i }

fun grow2(arr: IntArray): Int? =
    arr.reduceOrNull(Int::times)

fun grow3(arr: IntArray): Int {
    var result = 1
    arr.forEach { result *= it }
    return result
}