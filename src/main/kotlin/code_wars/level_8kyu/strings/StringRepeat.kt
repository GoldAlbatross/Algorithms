package code_wars.level_8kyu.strings
/*
повторить строку н раз
 */

fun main() {
    println(
        repeatStr2(4, "a"))
}

fun repeatStr(r: Int, str: String) : String =
    str.repeat(r)

fun repeatStr1(r: Int, str: String):String =
    (1..r).map { str }.joinToString("x")

fun repeatStr2(r: Int, str: String) =
    r.downTo(1).joinToString("") { str }