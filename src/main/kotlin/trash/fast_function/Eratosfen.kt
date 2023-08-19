package trash.fast_function

import java.util.*

private fun main() {
    println(sieveOfEratosthenes((1_000_000)))
}
private fun sieveOfEratosthenes(n: Int): List<Int> {
    val prime = BooleanArray(n + 1) { true }
    var p = 2
    while (p * p <= n) {
        if (prime[p]) {
            var i = p * 2
            while (i <= n) {
                prime[i] = false
                i += p
            }
        }
        p++
    }
    val primeNumbers = LinkedList<Int>()
    for (i in 2..n)
        if (prime[i])
            primeNumbers.add(i)
    return primeNumbers
}

//GPT
fun sieveOfEratosthenes2(n: Int): List<Int> {
    val isPrime = BooleanArray(n + 1) { true }
    val primes = mutableListOf<Int>()

    for (p in 2..n) {
        if (isPrime[p]) {
            primes.add(p)
            for (i in p * p..n step p) {
                isPrime[i] = false
            }
        }
    }

    return primes
}