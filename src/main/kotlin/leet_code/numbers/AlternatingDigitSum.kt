package leet_code.numbers

fun main() {
    println(maxDistance(intArrayOf(4,4,4,11,4,4,11,4,4,4,4,4)))
}

fun maxDistance(colors: IntArray): Int {
    var firstAttempt = 1
    var secondAttempt = 1

    for (i in colors.lastIndex downTo 1) {
        val left = colors[0]
        val right = colors[i]
        if (left != right) {
            firstAttempt = i
            break
        }
    }

    for (i in 0 until colors.lastIndex) {
        val right = colors[colors.lastIndex]
        val left = colors[i]
        if (left != right) {
            secondAttempt = colors.lastIndex - i
            break
        }
    }

    return firstAttempt.coerceAtLeast(secondAttempt)

}