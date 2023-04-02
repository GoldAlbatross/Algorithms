package code_wars.level_7kyu.numbers

/*
высчитать количество рулонов обоев
 */

fun main() {
    println(wallpaper(4.0, 3.5, 3.0))
}

fun wallpaper(l:Double, w:Double, h:Double):String {
    val numbers = listOf("zero", "one", "two", "three", "four", "five",
        "six", "seven", "eight", "nine", "ten", "eleven", "twelve","thirteen",
        "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty")
    return if (l*w*h <= 0) "zero"
    else numbers[Math.ceil(2 * (l+w) * h * 1.15f / 5.2).toInt()]
}