package code_wars.level_7kyu.array

/*
Найти сколько раз в списке меняется знак у элемента
 */

fun main() {
    catchSignChange(arrayOf(47,-84,30,-11,-5,74,77,-8))
    catchSignChange1(arrayOf(47,-84,30,-11,-5,74,77,-8))
    catchSignChange2(arrayOf(47,-84,30,-11,-5,74,77,-8))
}
//----------------------------------------------------------------------------------------------------------------------
fun catchSignChange(arr: Array<Int>): Int {
    var count = 0
    if (arr.isEmpty()) return 0
    val list = arr.map {if (it < 0) -1 else 1 }
    for (i in 1..list.lastIndex) {
        if (list[i-1] != list[i]) count++
    }
    return count
}
//----------------------------------------------------------------------------------------------------------------------
fun catchSignChange1(arr: Array<Int>): Int = arr
        .map { it < 0 }
        .zipWithNext { a, b -> a != b }
        .count { it }
//----------------------------------------------------------------------------------------------------------------------
fun catchSignChange2(arr: Array<Int>): Int = arr
    .asSequence()
    .windowed(2)
    .count { (x, y) -> (x >= 0) != (y >= 0) }
//----------------------------------------------------------------------------------------------------------------------