package leet_code.numbers

fun main() {
    println(isPalindrome(200))
}

//======================================================================================================================
private fun isPalindrome(x: Int): Boolean {

    return when {
        (x < 0) -> return false
        (x == 0) -> return true
        (x % 10 == 0) -> return false
        else -> revers(x.toULong())
    }
}
private fun revers(x: ULong): Boolean {
    var turn = 0UL
    var temp = x
    while (temp > turn) {
        turn = turn*10UL + temp%10UL
        if (temp == turn) return true
        temp /= 10UL
    }
    return temp == turn
}
//======================================================================================================================
fun isPalindrome2(x: Int): Boolean =
    x.toString().let { it == it.reversed() }
//======================================================================================================================