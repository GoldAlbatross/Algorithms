package code_wars.level_8kyu.arrays

fun main() {
    val numbers: Array<Int> = arrayOf(1, 2, 3, 4,-5,-2,0, 5)
    println(countPositivesSumNegatives(numbers).contentToString())
    println(countPositivesSumNegatives1(numbers).contentToString())
    println(countPositivesSumNegatives2(numbers).contentToString())
}

fun countPositivesSumNegatives(input: Array<Int>?) : Array<Int> {
    if (input.isNullOrEmpty()) return emptyArray()
    input
        .partition { it > 0 }
        .let { return arrayOf(it.first.count(),it.second.sum()) }
}

fun countPositivesSumNegatives1(input : Array<Int>?) : Array<Int> {
    if (input.isNullOrEmpty()) return emptyArray()
    val (positive, negative) = input.partition { it > 0 }
    return arrayOf(positive.count(), negative.sum())
}

fun countPositivesSumNegatives2(input : Array<Int>?) : Array<Int> =
    if (input.isNullOrEmpty())
        arrayOf()
    else
        arrayOf(input.count { it > 0 }, input.filter{ it < 0 }.sum())