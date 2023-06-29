package leet_code.arrays


private fun main() {
    println(
        searchInsert(intArrayOf(1,3,5,6), 5)
    )
}

//======================================================================================================================
fun searchInsert(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.lastIndex
    while (left <= right) {
        val index = (left + right) / 2
        when {
            target < nums[index] -> right = index - 1
            target > nums[index] -> left = index + 1
            target == nums[index] -> return index
        }
    }
    return left
}