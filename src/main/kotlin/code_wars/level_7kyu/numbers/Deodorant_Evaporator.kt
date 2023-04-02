package code_wars.level_7kyu.numbers

import kotlin.math.ceil
import kotlin.math.ln

/*
Рассчитать количество дней работы испарителя.Всего пены/газа - content. Каждый день испаряется evap_per_day, остаток при котором испарение
заканчивается - threshold.
 */

fun main(){

    println(evaporator(10.0,10.0,10.0))
    println(evaporator1(10.0,10.0,10.0))
    println(evaporator2(10.0,10.0,10.0))
}
//----------------------------------------------------------------------------------------------------------------------
fun evaporator(content: Double, evap_per_day: Double, threshold: Double): Int {
    val outOfUse = content * threshold / 100
     return generateSequence(content){ if (it >= outOfUse) it - (it * evap_per_day / 100) else null}
         .count() -1
}
//----------------------------------------------------------------------------------------------------------------------
fun evaporator1(content: Double, evap_per_day: Double, threshold: Double): Int {
    val step = evap_per_day / 100
    val residue = threshold / 100
    return ceil(ln(residue) / ln(1 - step)).toInt()
}
//----------------------------------------------------------------------------------------------------------------------
fun evaporator2(content: Double, evap_per_day: Double, threshold: Double): Int =
    generateSequence(content) { it - (it / 100 * evap_per_day) }
    .takeWhile { it > content / 100 * threshold }
    .count()
