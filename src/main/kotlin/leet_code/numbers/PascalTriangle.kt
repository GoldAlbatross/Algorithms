package leet_code.numbers

fun main() {
    println(generate(5))
}

private fun generate2(numRows: Int): List<List<Int>> {
    val resultList = mutableListOf(listOf(1))
    var index = 0
    while (index < numRows-1) {

        val list = mutableListOf<Int>()
        for (i in 0..resultList[index].lastIndex) {
            if ((i-1) < 0) {
                list.add(1)
            } else {
                list.add(resultList[index][i-1] + resultList[index][i])
            }
        }
        list.add(1)
        resultList.add(list as List<Int>)
        index++
    }
    return resultList

}
//======================================================================================================================
private fun generate(numRows: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    repeat(numRows) { num ->
        result.add(MutableList(num + 1) { item ->
            when (item) {
                0, num -> 1
                else -> result[num - 1][item - 1] + result[num - 1][item]
            }
        })
    }
    return result
}