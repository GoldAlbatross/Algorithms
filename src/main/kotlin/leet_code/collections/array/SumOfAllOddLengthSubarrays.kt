package leet_code.collections.array
/**
 *Given an array of positive integers arr, return the sum of all possible odd-length subarrays of arr.
 *
 * A subarray is a contiguous subsequence of the array.
 *
 *
 * Example 1:
 * Input: arr = [1,4,2,5,3]
 * Output: 58
 * Explanation: The odd-length subarrays of arr and their sums are:
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 *
 * Example 2:
 * Input: arr = [1,2]
 * Output: 3
 * Explanation: There are only 2 subarrays of odd length, [1] and [2]. Their sum is 3.
 *
 * Example 3:
 * Input: arr = [10,11,12]
 * Output: 66
 * */
fun main() {
    println(sumOddLengthSubarrays(intArrayOf(1,4,2,5,3)))
}

fun sumOddLengthSubarrays(arr: IntArray): Int {
    var count = 0
    var end = 1
    val list = arr.toList()

    while(end <= arr.size) {
        for (i in 0..arr.lastIndex) {
            if (end + i <= arr.size) {
                count += list.subList(i, end + i).sum()
            }
        }
        end += 2
    }

    return count
}
//======================================================================================================================

fun sumOddLengthSubarrays2(arr: IntArray): Int {
    var res = 0
    for (i in arr.indices) {
        val allCount = (arr.size - i) * (i + 1)
        val oddCount = if (allCount % 2 == 0) allCount / 2 else allCount / 2 + 1
        res += oddCount * arr[i]
    }
    return res
}

