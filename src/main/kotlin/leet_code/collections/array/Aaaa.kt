package leet_code.collections.array

fun main() {
    println(longestAlternatingSubarray(intArrayOf(1,2),2))
}

fun longestAlternatingSubarray(nums: IntArray, threshold: Int): Int {
    val map = hashMapOf<Int, Pair<Int,Int>>()
    var max = 0

    for(i in 0..nums.lastIndex) {
        if (nums[i] % 2 == 0) {
            map[nums[i]] = Pair(i, i)
        }
    }

    for(i in 0..nums.lastIndex) {
        if (nums[i] % 2 == 0) {
            if (i < nums.lastIndex) {
                if(nums[i] % 2 != nums[i + 1] % 2) {
                    for(j in i .. nums.lastIndex) {
                        if(nums[j] <= threshold) {
                            map[nums[i]] = Pair(i, j+1)
                        }
                    }
                }
            } else {
                for(j in i .. nums.lastIndex) {
                    if(nums[j] <= threshold) {
                        map[nums[i]] = Pair(i, j+1)
                    }
                }
            }


        }
    }

    for(m in map) {
        if(m.value.second - m.value.first > max) {
            max = m.value.second - m.value.first
        }
    }

    return max
}