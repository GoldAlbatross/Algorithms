package leet_code.collections.array

import java.lang.Math.abs
/**
 * Given an array of integers nums, you start with an initial positive value startValue.
 * In each iteration, you calculate the step by step sum of startValue
 * plus elementsin nums (from left to right).
 * Return the minimum positive value of startValue such that the step by step sum is never less than 1.
 *
 * Example 1:
 * Input: nums = [-3,2,-3,4,2]
 * Output: 5
 * Explanation: If you choose startValue = 4, in the third iteration your step by step sum is less than 1.
 * step by step sum
 * startValue = 4 | startValue = 5 | nums
 *   (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
 *   (1 +2 ) = 3  | (2 +2 ) = 4    |   2
 *   (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
 *   (0 +4 ) = 4  | (1 +4 ) = 5    |   4
 *   (4 +2 ) = 6  | (5 +2 ) = 7    |   2
 *
 * Example 2:
 * Input: nums = [1,2]
 * Output: 1
 * Explanation: Minimum start value should be positive.
 *
 * Example 3:
 * Input: nums = [1,-2,-3]
 * Output: 5
 * */
fun main() {
    println(minStartValue(intArrayOf(-3,2,-3,4,2)))
}

fun minStartValue(nums: IntArray): Int {
    var count = 0
    val x = nums.lastIndex
    nums.fold(0) { acc,it ->
        if (acc+it < count) count = acc+it
        println(acc)
        acc+it
    }
    return abs(count) +1
}


//  -3    =-3  -> 5-3=2
// -3+2   =-1  -> 2+2=4
// -3+2-3 =-4  -> 4-3=1
// -4+4   =0
// 0+2    =2

// складывать в каунт только если акк меньше
// акк по абс +1 рес