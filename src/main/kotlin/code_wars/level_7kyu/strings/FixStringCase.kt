package code_wars.level_6kyu.level_7kyu
/*
Определить каких букв больше(заглавных или строчных) и переделать строку
 */

fun main() {
    println(solve("CODer"))
    println(solve1("CODer"))
    println(solve2("CODer"))
}

fun solve(s: String): String {
    val a = s.filter { it.code in 65..90 } //uppercase letter
    val b = s.filter { it.code in 97..122 } //lowercase letter
    return if (a.length > b.length) s.uppercase() else s.lowercase()
}

fun solve1(s: String): String =
    if (s.count { it.isLowerCase() } >= s.length/2.0) s.lowercase()
    else s.uppercase()

fun solve2(s: String): String = s
    .partition { it.code < 91 }
    .let {
        return if (it.first.length > it.second.length) s.uppercase()
        else s.lowercase()
    }