package leet_code.numbers

// Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
//Input: rowIndex = 3
//Output: [1,3,3,1]
fun main() {
    println(getRow(3))
}

fun getRow2(rowIndex: Int): List<Int> {
    val result = mutableListOf<List<Int>>()

    repeat(rowIndex+1) { index ->
        result.add(MutableList(index + 1) { item ->
            when (item) {
                0,index -> 1
                else -> result[index-1][item-1] + result[index-1][item]
            }
        })
    }
    return result.last()
}
//======================================================================================================================

fun getRow(rowIndex: Int): List<Int> =
    generateSequence(listOf(1)) { list ->
        listOf(1) + list.windowed(2) { it.sum() } + 1
    }.elementAtOrElse(rowIndex) { listOf() }