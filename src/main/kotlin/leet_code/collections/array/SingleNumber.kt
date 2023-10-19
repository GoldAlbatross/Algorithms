package leet_code.collections.array
// Given a non-empty array of integers nums, every element appears twice except for one.
// Find that single one.
//You must implement a solution with a linear runtime complexity and use only constant extra space.

// Example 2:
//Input: nums = [4,1,2,1,2]
//Output: 4
fun main() {
    println(singleNumber(intArrayOf(4,1,2,1,2)))
}

fun singleNumber2(nums: IntArray): Int {
    val map = HashMap<Int, Int>(nums.size/2 + 1)
    nums.forEachIndexed { _, item ->
        map[item] = map.getOrDefault(item, 0) + 1
    }
    return map.filter { it.value == 1 }.keys.first()
}
//======================================================================================================================
fun singleNumber(nums: IntArray): Int {
    return nums.reduce { prev, curr ->
        prev xor curr
    }
}