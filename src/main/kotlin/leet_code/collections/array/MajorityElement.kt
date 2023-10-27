package leet_code.collections.array
/**
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 *
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 */
fun main() {
    println(majorityElement(intArrayOf(1,1,1,1,3,2,3,4,5)))
}

private fun majorityElement(nums: IntArray): Int {

    val count = hashMapOf<Int,Int>()
    for (num in nums) {
        count[num] = 1 + count.getOrDefault(num, 0)
        if (count[num]!! > nums.size/2) return num
    }

    return -1
}
//======================================================================================================================
