package code_wars.level_6kyu.level_7kyu
/*
In this little assignment you are given a string of space separated numbers,
and have to return the highest and lowest number
 */

fun main() {
    println(highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"))
    println(highAndLow2("8 3 -5 42 -1 0 0 -9 4 7 4 -4"))
}

fun highAndLow(numbers: String): String {
    val x = numbers.split(" ").map { it.toInt() }
    return "${x.max()} ${x.min()}"
}

fun highAndLow2(numbers: String): String {
    val x = numbers.split(" ").map { it.toInt() }.sorted()
    return "${x.last()} ${x.first()}"
}