package leet_code.strings

/**
 * Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
 * For example:
 *
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
*/
fun main() {
    println(convertToTitle2(701))
    println(convertToTitle(701))
}

private fun convertToTitle2(columnNumber: Int): String {
    val list = ('A'..'Z').toList()
    val str = StringBuilder()
    var current = columnNumber

    fun divide(num: Int) {
        str.insert(0, list[(num-1) % 26])
        current = (num-1) / 26
        if (current > 0) {
            divide(current)
        }
    }
    divide(columnNumber)
    return str.toString()
}
//======================================================================================================================

private fun convertToTitle(columnNumber: Int): String = buildString {
    var num = columnNumber
    while (num > 0) {
        insert(0, ((num - 1) % 26 + 'A'.code).toChar())
        num = (num - 1) / 26
    }
}