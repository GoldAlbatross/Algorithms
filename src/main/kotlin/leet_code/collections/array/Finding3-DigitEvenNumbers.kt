package leet_code.collections.array
/**
 * You are given an integer array digits, where each element is a digit. The array may contain duplicates.
 *
 * You need to find all the unique integers that follow the given requirements:
 *
 * The integer consists of the concatenation of three elements from digits in any arbitrary order.
 * The integer does not have leading zeros.
 * The integer is even.
 * For example, if the given digits were [1, 2, 3], integers 132 and 312 follow the requirements.
 *
 * Return a sorted array of the unique integers.
 *
 *
 *
 * Example 1:
 *
 * Input: digits = [2,1,3,0]
 * Output: [102,120,130,132,210,230,302,310,312,320]
 * Explanation: All the possible integers that follow the requirements are in the output array.
 * Notice that there are no odd integers or integers with leading zeros.
 * Example 2:
 *
 * Input: digits = [2,2,8,8,2]
 * Output: [222,228,282,288,822,828,882]
 * Explanation: The same digit can be used as many times as it appears in digits.
 * In this example, the digit 8 is used twice each time in 288, 828, and 882.
 * Example 3:
 *
 * Input: digits = [3,7,5]
 * Output: []
 * Explanation: No even integers can be formed using the given digits.
 * */

fun main() {
    println(
        findEvenNumbers(intArrayOf(2,1,3,0)).contentToString()
    )

}

fun findEvenNumbers2(digits: IntArray): IntArray {
    var num = 100
    val arr = mutableListOf<Int>()
    val mapMain = hashMapOf<Int,Int>()
    digits.forEach { mapMain[it] = mapMain.getOrDefault(it, 0) + 1 }

    while(num <= 998) {
        val map = hashMapOf<Int,Int>()
        map.putAll(mapMain)
        var flag = true

        num.toString().forEach {
            val n = it.digitToInt()
            if (n in map) {
                if (map[n]!! >= 1){
                    map[n] = map[n]!! - 1
                }
                else flag = false
            } else flag = false
        }
        if (flag) { arr.add(num) }
        num += 2
        flag = true
    }

    return arr.toIntArray()
}

//======================================================================================================================

fun findEvenNumbers(digits: IntArray): IntArray {
    return (100..999).filter {
            n -> n.toString().all {  //102
            d -> digits.count { it == d.digitToInt() } >=  n.toString().count { it == d }
    }
    }.filter { it % 2 == 0 }.toIntArray()
}









