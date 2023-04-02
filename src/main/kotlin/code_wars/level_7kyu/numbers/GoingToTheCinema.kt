package code_wars.level_7kyu.numbers
import kotlin.math.ceil
import kotlin.math.pow

/*
Рассчитать сколько билетов нужно купить, чтоб окупить аванс
 */

fun main() {
    //println(movie(0,10,0.95))
    //println(movie1(0,10,0.95))
}

fun movie(card:Int, ticket:Int, percentage:Double):Int {
    var times = 0
    var a: Int
    var b = card + 0.0
    do {
        ++times
        a = ticket * times
        b += ticket * percentage.pow(times)
    } while (ceil(b).toInt() >= a)
    return times
}

fun movie1(card:Int, ticket:Int, percentage:Double): Int {
     return generateSequence(1) { it + 1 }
        .first { ticket * it > ceil(card + ticket * percentage * (1 - percentage.pow(it)) / (1 - percentage)) }
}

