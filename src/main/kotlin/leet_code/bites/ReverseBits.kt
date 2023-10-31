package leet_code.bites


/**
 * Reverse bits of a given 32 bits unsigned integer.Note:
 * Note that in some languages, such as Java, there is no unsigned integer type.
 * In this case, both input and output will be given as a signed integer type.
 * They should not affect your implementation, as the integer's internal binary representation is the same,
 * whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation.
 * Therefore, in Example 2 above, the input represents the signed integer -3
 * and the output represents the signed integer -1073741825.
 *
 * Example 1:
 *
 * Input: n = 00000010100101000001111010011100
 * Output:    964176192 (00111001011110000010100101000000)
 * Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
*/
fun main() {
    println(reverseBits(1210061376))
}

fun reverseBits2(n:Int): String {
    println(Integer.toBinaryString(964176192))
    var x = buildString {
        n.toByte().toString().forEach {
            if (it == '0') append('1') else append('0')
        }
    }
    return x
}
//======================================================================================================================
fun reverseBits(n:Int):Int {
    var num = n
    var result = 0

    repeat (32) {
        result = result shl 1
        result = result or (num and 1)
        num = num shr 1
    }
    return result
}