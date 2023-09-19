package leet_code.arrays


private fun main() {
    println(
        searchInsert(intArrayOf(1,3,5,6), 7)
    )
}
fun searchInsert2(nums: IntArray, target: Int): Int {
    val pos = nums.binarySearch(target)
    return if (pos >= 0) pos else -pos -1
}
//======================================================================================================================
fun searchInsert(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.lastIndex
    while (left <= right) {
        val index = (left + right) / 2
        when {
            target == nums[index] -> return index
            target+1 == nums[index] -> return index
            target-1 == nums[index] -> return index+1
            target < nums[index] -> right = index - 1
            target > nums[index] -> left = index + 1
        }
    }
    return left
}