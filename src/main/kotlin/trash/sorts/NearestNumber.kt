package interview.sorts

import kotlin.math.abs



fun main() {
    var numbers = arrayOf(-1, 10, 25, -300, -3, 4, 5, 10, 3, 150, -6)
    val num = -7



    numbers = numbers.sorted().toTypedArray()

    do {
        if (numbers[numbers.size / 2] > num) {
            numbers = numbers.copyOfRange(0, numbers.size / 2 + 1)
            println(numbers.contentToString())
        }
        else if (numbers[numbers.size / 2] < num) {
            numbers = numbers.copyOfRange(0, numbers.size / 2 + 1)
            println(numbers.contentToString())
        }
        if (numbers.size == 2) {
            if (abs( numbers[0] - num) < abs( numbers[1] - num)) numbers = arrayOf( numbers[0])
            else numbers = arrayOf( numbers[1])
        }
    } while (numbers.size != 1)
    println(numbers.contentToString())

}

