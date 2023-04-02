package code_wars.level_7kyu.strings
/*
Given a string, capitalize the letters that occupy even indexes and odd indexes separately,
and return as shown below. Index 0 will be considered even.
 */

fun main() {
    println(capitalize("abcdef"))
    println(capitalize1("abcdef"))
    println(capitalize2("abcdef"))
    println(capitalize3("abcdef"))
}

fun capitalize(text: String): List<String> {
    val first = text.mapIndexed { index, it -> if (index % 2 == 0) it.uppercase() else it }.joinToString("")
    val second = text.mapIndexed { index, it -> if (index % 2 != 0) it.uppercase() else it }.joinToString("")
    return listOf(first, second)
}
//----------------------------------------------------------------------------------------------------------------------
fun capitalize1(text: String): List<String> =
    listOf(
        text.mapIndexed { index, c -> if (index.rem(2) == 0) c.uppercase() else c }.joinToString(""),
        text.mapIndexed { index, c -> if (index.rem(2) == 1) c.uppercase() else c }.joinToString("")
    )
//----------------------------------------------------------------------------------------------------------------------
fun capitalize2(text: String) =
    (0..1).map{ text.mapIndexed { i, c -> if (i % 2 == it) c.uppercase() else c }.joinToString("") }
//----------------------------------------------------------------------------------------------------------------------
fun capitalize3(text: String): List<String> =
    listOf(text.capSwitcher(1), text.capSwitcher(0))

fun String.capSwitcher(start: Int) =
    this.mapIndexed{ index, char -> char.capIf(index.rem(2) == start) }.joinToString("")

fun Char.capIf(cap: Boolean): Char =
    if(cap) this else this.uppercaseChar()