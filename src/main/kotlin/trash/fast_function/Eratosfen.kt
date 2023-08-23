package trash.fast_function

import trash.memory.checkPerformance

private fun main() {
    val startTime = System.currentTimeMillis()

    println(sieveOfEratosthenes((10_000_000)).size)

    checkPerformance(startTime)
}

//GPT
fun sieveOfEratosthenes(n: Int): List<Int> {
    val isPrime = BooleanArray(n + 1) { true }
    val primes = mutableListOf<Int>()

    for (num in 2..n) {
        if (isPrime[num]) {
            primes.add(num)
            var multiple = num * num.toLong()
            while (multiple <= n) {
                isPrime[multiple.toInt()] = false
                multiple += num
            }
        }
    }

    return primes
}