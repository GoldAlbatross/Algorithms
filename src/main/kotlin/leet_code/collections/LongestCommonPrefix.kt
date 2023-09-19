package leet_code.arrays

fun main() {
    val array = arrayOf("flower","flow","flight")
    println(longestCommonPrefix(array))

}
//======================================================================================================================
private fun longestCommonPrefix(array: Array<String>) =
    StringBuilder().apply {
        array.minBy { it.length }
            .forEachIndexed { i, char ->
            if (array.all { str -> str[i] == char }) append(char)
            else return this@apply.toString() }
    }.toString()

//======================================================================================================================

private fun longestCommonPrefix2(strs: Array<String>): String {
    val word = strs[0]
    word.forEachIndexed { i, c ->
        if (strs.any { it.length == i || it[i] != c }) return word.substring(0, i)
    }
    return word
}