package trash.sorts

import kotlin.math.min

// Создай массив size10 примитивов range(1..100)
// Найди второй по минимальности эл.
// Найди в один проход
// Проверь, если все элементы одинаковые
fun main() {
    val intArray = IntArray(10) { (1..100).random() }
    println(intArray.contentToString())
    var min = Int.MAX_VALUE
    var min2 = Int.MAX_VALUE

    intArray.forEach {
        if (it < min) {
            min2 = min;
            min = it
        }
        else if (it < min2 && it != min) {
            min2 = it
        }
    }

    if (min2 != Int.MAX_VALUE) println(min2) else println("No such item")
    println(min)

}