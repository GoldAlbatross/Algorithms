package code_wars.level_7kyu.strings
/*
найти буквы содержащиеся в одной из двух строк и вывести в алфавитном порядке
 */

fun main() {
    println(longest("aretheyhere", "yestheyarehere"))
    println(longest1("aretheyhere", "yestheyarehere"))
    println(longest2("aretheyhere", "yestheyarehere"))
    println(longest3("aretheyhere", "yestheyarehere"))
}

fun longest(s1:String, s2:String):String =
    CharRange('a','z')
        .filter { (s1 + s2).contains(it) }
        .joinToString("")

fun longest1(s1:String, s2:String):String =
    (s1 + s2)
        .toSortedSet()
        .joinToString("")

fun longest2(s1:String, s2:String):String =
    "abcdefghijklmnopqrstuvwxyz".filter { it in s1 || it in s2 }

fun longest3(s1:String, s2:String) =
    (s1+s2).toCharArray()
        .distinct()
        .sorted()
        .joinToString("")


