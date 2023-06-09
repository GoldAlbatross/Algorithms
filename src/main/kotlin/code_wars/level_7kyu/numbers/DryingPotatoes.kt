package code_wars.level_7kyu.numbers

/*
в картошке 99% води и 1% сухого вещества. Её положили в духовку.
Содержание воды стало 98%.Сколько веса потеряно?
 */

fun main() {
    println(potatoes(82, 127, 80))
    println(potatoes1(82, 127, 80))
}
//----------------------------------------------------------------------------------------------------------------------
fun potatoes(p0:Int, w0:Int, p1:Int):Int {
    val dryMatterReduction =  (100.0 - p0) / (100.0 - p1)
    return (w0 * dryMatterReduction).toInt()
}
//----------------------------------------------------------------------------------------------------------------------
fun potatoes1(p0: Int, w0: Int, p1: Int) =
    w0 * (100 - p0) / (100 - p1)
//----------------------------------------------------------------------------------------------------------------------