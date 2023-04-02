package code_wars.level_7kyu.strings

fun main() {
    println(moveTen("testcase"))
    println(moveTen1("testcase"))
}

fun moveTen(s: String): String = s
        .map { ((it.code -87) %26 +97).toChar() }
        .joinToString ( "" )

fun moveTen1(s: String): String {
    val chars = "abcdefghijklmnopqrstuvwxyz".repeat(2)
    return s.map { chars[chars.indexOf(it.toString()) + 10] }.joinToString("");
}