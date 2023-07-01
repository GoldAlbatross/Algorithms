package leet_code.arrays

private fun main() {
   println(plusOne(
       intArrayOf(9,9,9,7)).contentToString()
   )
}

private fun plusOne(digits: IntArray): IntArray {

    for (i in digits.lastIndex downTo 0) {
        if(digits[i] + 1 == 10) digits[i] = 0
        else return digits.also { ++digits[i] }
    }
    return intArrayOf(1, *digits)
}
