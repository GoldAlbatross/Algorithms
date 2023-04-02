package code_wars.level_8kyu.arrays
/*
суммировать массив из челых чисел и стринговых чисел
 */
fun main(){
    println(
        sum1(mutableListOf(1,2,"4","3"))
    )
}

fun sum(mixed: List<Any>): Int =
    mixed.sumOf { it.toString().toInt() }


fun sum1(mixed: List<Any>): Int =
    mixed.sumOf { "$it".toInt() }


fun sum2(mixed: List<Any>): Int = mixed.sumOf {
    when(it) {
        is Int -> it
        is String -> it.toInt()
        else -> 0
    }
}