package code_wars.level_8kyu
/*
Simple, remove the spaces from the string, then return the resultant string.
*/

fun main() {
    println(noSpace("sdvdsv  sddgs dsfsd fa s"))
    println(noSpace1("sdvdsv  sddgs dsfsd fa s"))
}


fun noSpace(x: String): String =
    x.replace(" ", "", true)


fun noSpace1(x: String) =
    x.filterNot { it.isWhitespace() }
