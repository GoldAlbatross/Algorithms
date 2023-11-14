package leet_code.collections.array
/**
 *You are given a 0-indexed integer array nums. In one operation, you may do the following:
 *
 * Choose two integers in nums that are equal.
 * Remove both integers from nums, forming a pair.
 * The operation is done on nums as many times as possible.
 *
 * Example 1:
 * Input: nums = [1,3,2,1,3,2,2]
 * Output: [3,1]
 * Explanation:
 * Form a pair with nums[0] and nums[3] and remove them from nums. Now, nums = [3,2,3,2,2].
 * Form a pair with nums[0] and nums[2] and remove them from nums. Now, nums = [2,2,2].
 * Form a pair with nums[0] and nums[1] and remove them from nums. Now, nums = [2].
 * No more pairs can be formed. A total of 3 pairs have been formed, and there is 1 number leftover in nums.
 *
 * Example 2:
 * Input: nums = [1,1]
 * Output: [1,0]
 * Explanation: Form a pair with nums[0] and nums[1] and remove them from nums. Now, nums = [].
 * No more pairs can be formed. A total of 1 pair has been formed, and there are 0 numbers leftover in nums.
 *
 * Example 3:
 * Input: nums = [0]
 * Output: [0,1]
 * Explanation: No pairs can be formed, and there is 1 number leftover in nums.
 * */
fun main() {
    println(numberOfPairs(intArrayOf(1,2,3,5)))
}

fun numberOfPairs(nums: IntArray): IntArray {
    var count = 0

    for (i in 0 until nums.lastIndex) {
        val num = nums[i]
        if (num != -1) {
            for (j in i+1..nums.lastIndex) {
                if (num == nums[j]) {
                    count++
                    nums[i] = -1
                    nums[j] = -1
                    break
                }
            }
        }
    }

    return intArrayOf(count, nums.size - count*2)
}
