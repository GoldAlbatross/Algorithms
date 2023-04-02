package code_wars.level_6kyu.numbers

import java.math.BigInteger
import kotlin.math.sqrt

fun main() {
    println(solve(3L))
}


fun solve(n: Long): String {
    getFactors(n - 1).forEach {
        val mod = powMod(10L, it, n)
        if (mod == 1L) return "$it-sum"
        if (mod == n - 1) return "$it-altsum"
    }
    return ""
}

fun getFactors(n: Long): List<Long> {
    val factors = mutableSetOf(1L, n)
    for (i in 2L until sqrt(n.toDouble()).toLong() + 1) {
        if (n % i == 0L) {
            factors.add(i)
            factors.add(n / i)
        }
    }
    return factors.sorted()
}

fun powMod(base: Long, exp: Long, mod: Long): Long {
    val b = BigInteger(base.toString())
    val e = BigInteger(exp.toString())
    val m = BigInteger(mod.toString())
    val res = b.modPow(e, m)
    return res.toLong()
}