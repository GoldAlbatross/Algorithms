package code_wars.level_7kyu.array
/*
посчитать стоимость проезда по маршруту
 */

fun main() {
    println(londonCityHacker(arrayOf(12, "Central", "Circle", 21)))
    println(londonCityHacker1(arrayOf(12, "Central", "Circle", 21)))
}
//----------------------------------------------------------------------------------------------------------------------
fun londonCityHacker(journey: Array<Any>): String =
    journey.joinToString("") { if (it is Int) "B" else "T" }
        .replace("BB", "B")
        .sumOf { if (it == 'B') 1.5 else 2.4 }
        .let { "£%.2f".format(it) }
//----------------------------------------------------------------------------------------------------------------------
fun londonCityHacker1(journey: Array<Any>) =
    journey.fold(0.0 to false) { (fare, bus), x ->
        when {
            x is String -> fare + 2.4 to false
            bus -> fare to false
            else -> fare + 1.5 to true
        }
    }.first.let { "£%.2f".format(it) }