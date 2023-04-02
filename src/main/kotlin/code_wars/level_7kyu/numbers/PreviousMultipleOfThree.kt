package code_wars.level_7kyu.numbers

fun main() {
    println(
        prevMultOfThree2(252406))
}

fun prevMultOfThree(n: Int): Int? {
    var x = n
    while (x % 3 != 0) { x /= 10 }
    return if (x > 0) x else null
}

fun prevMultOfThree1(n: Int): Int? = when {
    n == 0 -> null
    n % 3 == 0 -> n
    else -> prevMultOfThree(n / 10)
}

fun prevMultOfThree2(n: Int): Int? =
    generateSequence(n) { it / 10 }
        .find { it % 3 == 0 }
        .let { if (it == 0) null else it }