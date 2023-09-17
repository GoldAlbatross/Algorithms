package _contests.tinkoff_2

import java.util.Scanner
private fun main() {

    val scn = Scanner(System.`in`)
    val c: Int = scn.nextLine().split(" ").last().toInt()
    val p = scn.nextLine().split(" ").map { it.toInt() }

    println(getPrice(p, c))
}



fun getPrice(p: List<Int>, m: Int): Int {
    val sortedPrices = p.sorted()

    var low = 0
    var high = sortedPrices.lastIndex

    while (low <= high) {
        val mid = (low + high) / 2
        val guess = sortedPrices[mid]

        when {
            guess == m -> return guess
            guess > m -> high = mid - 1
            else -> {
                if (sortedPrices[mid + 1] > m && sortedPrices[mid + 1] != m) return guess
                low = mid + 1
            }
        }
    }
    return 0
}

