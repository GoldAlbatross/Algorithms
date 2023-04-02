package code_wars.level_7kyu.array
import kotlin.math.sqrt

/*
Take a list of ages when each of your great-grandparent died.
Multiply each number by itself.
Add them all together.
Take the square root of the result.
Divide by two.
 */


fun main() {
    println(predictAge(65,60,75,55,60,63,64,45))
    println(predictAge1(65,60,75,55,60,63,64,45))

}

fun predictAge(age1: Int, age2: Int, age3: Int, age4: Int, age5: Int, age6: Int, age7: Int, age8: Int): Int {
    return listOf(age1, age2, age3, age4, age5, age6, age7, age8)
        .sumOf { it * it }
        .toDouble()
        .let { sqrt(it) }
        .div(2)
        .toInt()
}

fun predictAge1(vararg ages: Int): Int =
    ages.sumOf { it * it }
        .toDouble()
        .let { sqrt(it) }
        .div(2)
        .toInt()