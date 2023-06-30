package leet_code.strings


private fun main() {
    println(
        lengthOfLastWord("   fly me   to   the moon  ")
    )
}

private fun lengthOfLastWord2(s: String): Int {
    return s.trimEnd().takeLastWhile { it != ' ' }.count()
}
//======================================================================================================================
private fun lengthOfLastWord(s: String): Int =
    s.trim().let { it.lastIndex - it.lastIndexOf(' ') }