package leet_code.numbers

/*
Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
The returned integer should be non-negative as well.
You must not use any built-in exponent function or operator.
 */

fun main() {
    println(mySqrt(20))
}

fun mySqrt(x: Int): Int {
    var left = 0
    var right = x/2+1

    while (left <= right) {
        var middle = (left + right)/2

        when {
            (x/middle == middle) -> return middle
            (x/middle > middle) -> left = middle+1
            (x/middle < middle) -> right = middle-1
        }
    }
    return right
}