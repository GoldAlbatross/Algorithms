package code_wars.level_6kyu.numbers


fun main() {
    println(int123(-123))
    println(int1232(500))
    println(int1233(500))

    println(Long.MAX_VALUE - 500 + 124 + 123)
}

fun int123(a: Int): Long {
    return Integer.toUnsignedLong(123 - a)
}
//----------------------------------------------------------------------------------------------------------------------
fun int1232(a: Int): Long = when {
    (a >= 0) && (a <= 123) -> 123L - a
    (a < 0) && (a > Int.MIN_VALUE + 123) -> 123L + a * (-1)
    (a > Int.MIN_VALUE) && (a <= Int.MIN_VALUE + 123) -> a - (Int.MIN_VALUE - 123L)
    else -> Int.MAX_VALUE.toLong() + Int.MAX_VALUE.toLong() - (a - 125L)
}
//----------------------------------------------------------------------------------------------------------------------
fun int1233(a: Int) =
    (123L - a).takeIf { it >= 0 } ?: (Long.MAX_VALUE - a + 124)