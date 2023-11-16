package leet_code.collections.array

fun main() {
    println(specialArray(intArrayOf(3,6,7,7,0)))
}

// 0 >= 0num [-1,-2,-3...]
//                  v
// -1 >=     [1,1,1,0]
//                  .
// 1 >= 1num [1,1,1,2]
//              .
// 2 >= 2num [1,1,2,3]
//              .
// 3 >= 3num [1,3,4,5]
//      .
// [0,0,3,4,4]
fun specialArray(nums: IntArray): Int {
    nums.sortDescending()
    println(nums.contentToString())
    var result = if (nums[nums.lastIndex] < nums.size) nums[nums.lastIndex] else nums.size
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

