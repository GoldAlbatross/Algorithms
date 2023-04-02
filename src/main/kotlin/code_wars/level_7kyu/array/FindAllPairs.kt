package code_wars.level_7kyu.array
/*
Найти число у которого есть пара и посчитать количество таких пар
 */

fun main() {
    println(duplicates1(intArrayOf(0, 0, 1, 1, 2, 2, 2)))

}
//----------------------------------------------------------------------------------------------------------------------
fun duplicates(array: IntArray): Int {
    if (array.isEmpty()) return 0
    var count = 0
    array.toList().sorted().reduce { acc, i -> if (acc == i) {count++; acc-1} else i  }
    return count }
//----------------------------------------------------------------------------------------------------------------------
fun duplicates1(array: IntArray) =
    array.groupBy { it }.map { it.value.size / 2 }.sum()
//----------------------------------------------------------------------------------------------------------------------
fun duplicates2(array: IntArray) =
    array.toSet().sumOf { x -> array.count { it == x } / 2 }
//----------------------------------------------------------------------------------------------------------------------