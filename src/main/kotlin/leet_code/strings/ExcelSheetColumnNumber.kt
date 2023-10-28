package leet_code.strings
/**
 * Given a string columnTitle that represents the column title as appears in an Excel sheet,
 * return its corresponding column number.
 *
 * For example:
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *
 * Example 1:
 * Input: columnTitle = "A"
 * Output: 1
*/
fun main() {
    println(titleToNumber("ZY"))
}
fun titleToNumber(columnTitle: String): Int {
    var count = 0
    repeat(columnTitle.length) {
        count *= ('Z' - 'A' + 1)
        count += columnTitle[it] - ('A' - 1)
    }

    return count
}