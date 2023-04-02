package code_wars.level_7kyu.strings
/*
Simple, given a string of words, return the length of the shortest word(s).
String will never be empty and you do not need to account for different data types.
 */

fun main() {
    /*println(findShort("bitcoin take over the world maybe who knows perhaps"))
    println(findShort1("bitcoin take over the world maybe who knows perhaps"))
    println(findShort2("bitcoin take over the world maybe who knows perhaps"))*/
    println(findShort3("bitcoin take over the world maybe who knows perhaps"))
}
//----------------------------------------------------------------------------------------------------------------------
fun findShort(s: String): Int {
    var size = 10
    s.split(" ").map {
        if (it.length == 1) return 1
        else if (it.length < size) size = it.length
    }
    return size
}
//----------------------------------------------------------------------------------------------------------------------
fun findShort1(s: String): Int =
    s.split(" ").minOf{ it.length }
//----------------------------------------------------------------------------------------------------------------------
fun findShort2(s: String): Int =
    s.split(" ").sortedBy { it.length }[0].length
//----------------------------------------------------------------------------------------------------------------------
fun findShort3(s: String): Int =
    s.split(" ").reduce { acc, i -> if (acc.length < i.length) acc else i }.length
//----------------------------------------------------------------------------------------------------------------------