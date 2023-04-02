package code_wars.level_8kyu

fun main() {
    println(reverseSeq(5))
}

fun reverseSeq(n: Int): List<Int> =
    List(n) { n-it}