package leet_code.collections.array
/**
 * Given an array of integers arr, return true if and only if it is a valid mountain array.
 * Recall that arr is a mountain array if and only if:
 *
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 *
 * Example 1:
 * Input: arr = [2,1]
 * Output: false
 *
 * Example 2:
 * Input: arr = [3,5,5]
 * Output: false
 *
 * Example 3:
 * Input: arr = [0,3,2,1]
 * Output: true
* */
fun main() {
    println(validMountainArray(intArrayOf(1,2,3)))
}

fun validMountainArray(arr: IntArray): Boolean {

    if (arr.size < 3) return false

    var previous = arr[0]
    var current = 0
    var isIncrease = true

    for (i in 1..arr.lastIndex) {

        current = arr[i]

        if (current < previous && isIncrease) {
            isIncrease = false
        }
        else if (current >= previous) return false
        previous = current

    }

    return isIncrease == false
}
//  max - 10^4
//  []
//  [3]
//  [32]
//    v
//  [321]
//  [333]
//    v
//  [342]
//  [123]


// check increase
// break point
// check decrease