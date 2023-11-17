package leet_code.collections.array
/**
 * You are given an array nums of non-negative integers. nums is considered special
 * if there exists a number x such that there are exactly x numbers in nums that are
 * greater than or equal to x.
 *
 * Notice that x does not have to be an element in nums.
 * Return x if the array is special, otherwise, return -1. It can be proven that
 * if nums is special, the value for x is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,5]
 * Output: 2
 * Explanation: There are 2 values (3 and 5) that are greater than or equal to 2.
 * Example 2:
 *
 * Input: nums = [0,0]
 * Output: -1
 * Explanation: No numbers fit the criteria for x.
 * If x = 0, there should be 0 numbers >= x, but there are 2.
 * If x = 1, there should be 1 number >= x, but there are 0.
 * If x = 2, there should be 2 numbers >= x, but there are 0.
 * x cannot be greater since there are only 2 numbers in nums.
 * Example 3:
 *
 * Input: nums = [0,4,3,0,4]
 * Output: 3
 * Explanation: There are 3 values that are greater than or equal to 3.
 * */
fun main() {
    println(specialArray(intArrayOf(3,6,7,7,0)))
}

// 0 >= 0num [-1,-2,-3...]
//                  v
// -1 >=     [0,0,0,1]
//                  v
// 1 >= 1num [1,1,1,2]
//              .
// 2 >= 2num [1,1,2,3]
//              .
// 3 >= 3num [1,3,4,5]
//      .
// [0,0,3,4,4]
fun specialArray(nums: IntArray): Int {
    val arr = nums.sortedDescending()
    println(arr)
    val max = arr[0]
    var result = if (max < arr.size) max else arr.size
    println(result)
    var count = 0

    while(result != -1) {
        println("result: $result")

        for (num in nums) {
            if (result <= num) {
                if (++count == result) return count
                println("count: $count")
            }
            else break
        }
        count = 0
        result--
    }

    return -1
}