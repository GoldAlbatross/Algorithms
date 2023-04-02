package code_wars.level_7kyu.strings

import kotlin.math.abs

/*
Написать программу вывода разных звуков в разное время.
 */

fun main() {
    println(fizzBuzzCuckooClock("04:00"))
    println(fizzBuzzCuckooClock1("04:00"))
    println(fizzBuzzCuckooClock2("04:00"))
}
//----------------------------------------------------------------------------------------------------------------------
fun fizzBuzzCuckooClock(time: String) : String {
    val (hour, minute) = time.split(":").map(String::toInt)
    return when {
        minute == 0 -> "Cuckoo "
                .repeat((hour % 12).let { if (it == 0) 12 else it })
                .dropLast(1)
        minute == 30 -> "Cuckoo"
        minute % 15 == 0 -> "Fizz Buzz"
        minute % 5 == 0 -> "Buzz"
        minute % 3 == 0 -> "Fizz"
        else -> "tick"
    }
}
//----------------------------------------------------------------------------------------------------------------------
fun fizzBuzzCuckooClock1(time: String): String {
    val (hours, minutes) = time.split(":").map { it.toInt() }
    return when {
        minutes == 0 -> List(if (hours in 1..12) hours else abs(hours - 12)) { "Cuckoo" }.joinToString(" ")
        minutes == 30 -> "Cuckoo"
        minutes % 15 == 0 -> "Fizz Buzz"
        minutes % 5 == 0 -> "Buzz"
        minutes % 3 == 0 -> "Fizz"
        else -> "tick"
    }
}
//----------------------------------------------------------------------------------------------------------------------
fun fizzBuzzCuckooClock2(time: String) =
    time.takeLast(2).toInt().let {
        when {
            it == 0 -> ("Cuckoo ".repeat((time.take(2).toInt() % 12).takeIf{ it != 0} ?: 12)).dropLast(1)
            it == 30 -> "Cuckoo"
            it % 15 == 0 -> "Fizz Buzz"
            it %  5 == 0 -> "Buzz"
            it %  3 == 0 -> "Fizz"
            else -> "tick"
        }
    }