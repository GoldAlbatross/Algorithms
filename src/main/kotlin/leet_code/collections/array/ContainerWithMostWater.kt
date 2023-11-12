package leet_code.collections.array

/**
 * You are given an integer array height of length n.
 * There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container,
 * such that the container contains the most water. Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 *
 * Example 1:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 *
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 * */

fun main() {
    println(maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)))
}

fun maxArea(height: IntArray): Int {
    var start = 0
    var end = height.lastIndex
    var value = 0
    var left: Int = -1
    var right: Int = -1



    while(start < end) {

        if (left < height[start])
            left = height[start]

        if (right < height[end])
            right = height[end]

        val temp = (end-start) * left.coerceAtMost(right)

        start++
        end--

        if (temp > value) value = temp
    }

    return value
}

//    v         v
// [1,8,6,2,5,4,8,3,7]