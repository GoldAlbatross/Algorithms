package leet_code.collections.array
/**
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: true
 * */
fun main() {
    println(containsDuplicate(intArrayOf(4,2,3,1)))
}

fun containsDuplicate(nums: IntArray): Boolean {

    val map = hashMapOf<Int,Int>()
    nums.forEach {
        map[it] = map.getOrDefault(it, 0) + 1
        if (map[it] == 2) return true
    }

    return false
}