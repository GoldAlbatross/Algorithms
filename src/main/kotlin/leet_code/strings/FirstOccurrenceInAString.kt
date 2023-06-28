package leet_code.strings

private fun main() {
    println(
        strStr("sadutsad", "sad")
    )
}
//======================================================================================================================
private fun strStr(haystack: String, needle: String): Int {
    val needleSize = needle.length

    haystack.forEachIndexed { index, char ->
        var endIndex = 0
        if (needle[0] == char) {
            if ((index + needleSize) > haystack.length) return@forEachIndexed
            else endIndex = index + needleSize
            val substring = haystack.substring(index, endIndex)
            if (needle == substring)
                return index
        }
    }
    return -1
}
//======================================================================================================================
fun strStr2(haystack: String, needle: String): Int = haystack.indexOf(needle)