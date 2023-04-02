package code_wars.level_7kyu.geometry

/*
найти сумму внутренних углов многоугольника
 */

fun main() {
    println(angle(4))
    println(angle1(4))
}

fun angle(n: Int): Int = 180 * (n - 2)
//----------------------------------------------------------------------------------------------------------------------
fun angle1(n: Int) = n.minus(2).times(180)