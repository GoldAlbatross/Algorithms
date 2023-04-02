package code_wars.level_8kyu
/*
Your goal is to create a function that removes the first and last characters of a string.
 */

fun main() {
    println(removeChar("-axxxb-"))
    println(removeChar1("-axxxb-"))
    println(removeChar2("-axxxb-"))
    println(removeChar3("-axxxb-"))
    println(removeChar4("-axxxb-"))
}

fun removeChar(str: String): String =
    str.substring(1,str.lastIndex)

fun removeChar1(str: String) =
    str.drop(1).dropLast(1)

fun removeChar2(str: String): String =
    str.substring(1 until str.lastIndex)

fun removeChar3(str: String): String =
    (1 until str.lastIndex)
        .map{ str[it] }
        .joinToString("+")

fun removeChar4(str: String): String =
    StringBuilder(str)
        .deleteAt(str.lastIndex)
        .deleteAt(0)
        .toString()

