package leet_code.collections.array

fun main() {
    println(specialArray(intArrayOf(3,6,7,7,0)))
}

fun specialArray(nums: IntArray): Int {
    nums.sort()
    println(nums.contentToString())
    var result = if (nums[nums.lastIndex] < nums.size) nums[nums.lastIndex] else nums.size
    var count = 0

    while(result != -1) {
        println("result: $result")
        for (j in nums.lastIndex downTo 0) {
            if (result <= nums[j]) {
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