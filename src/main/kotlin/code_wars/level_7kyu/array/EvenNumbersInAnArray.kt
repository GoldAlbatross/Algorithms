package code_wars.level_7kyu.array
/*
вывести последние четные элементы в количестве number из списка
 */

fun main() {
    println(evenNumbers(listOf(1, 2,0, 3, 4, 5, 6, 7, 8, 9), 3))
    println(evenNumbers1(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9), 3))
    println(evenNumbers2(listOf(1, 2,0, 3, 4, 5, 6, 7, 8, 9), 3))
}
//----------------------------------------------------------------------------------------------------------------------
fun evenNumbers(array: List<Int>, number: Int): List<Int> = array
    .filter { it % 2 == 0 }
    .reversed()
    .slice(0 until  number)
    .reversed()
//----------------------------------------------------------------------------------------------------------------------
fun evenNumbers1(array: List<Int>, number: Int) = array
    .filter{ it % 2 == 0 }
    .takeLast(number)
//----------------------------------------------------------------------------------------------------------------------
fun evenNumbers2(list: List<Int>, number: Int): List<Int> = list
    .filter { it % 2 == 0 }
    .run{ subList(size-number, size) }
//----------------------------------------------------------------------------------------------------------------------
