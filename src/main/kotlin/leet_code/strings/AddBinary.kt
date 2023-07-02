package leet_code.strings

import java.math.BigInteger

/*
Given two binary strings a and b, return their sum as a binary string.
 */
fun main() {
    println(
        addBinary("1010", "1011")
    )
}
//======================================================================================================================
fun addBinary2(a: String, b: String): String {
    var numA = a.toBigInteger(2)
    var numB = b.toBigInteger(2)

    while (numB != BigInteger.ZERO) {
        val sum = numA xor numB
        val carry = (numA and numB) shl 1
        numA = sum
        numB = carry
    }

    return numA.toString(2)
}
//======================================================================================================================
fun addBinary(a: String, b: String): String {
    var carry = 0
    var result = ""
    var i = a.lastIndex
    var j = b.lastIndex

    while (i >= 0 || j >= 0 || carry > 0) {
        val digitA = if (i >= 0) a[i--] -'0' else 0
        val digitB = if (j >= 0) b[j--] -'0' else 0
        val sum = digitA + digitB + carry
        val digitSum = sum % 2
        carry = sum / 2
        result = "$digitSum" + result
    }

    return result
}