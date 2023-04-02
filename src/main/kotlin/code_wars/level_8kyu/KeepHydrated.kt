package code_wars.level_8kyu

fun main() {
    println(litres(12.2))
}

fun litres(time: Double): Int =
    (time * 2).toInt()