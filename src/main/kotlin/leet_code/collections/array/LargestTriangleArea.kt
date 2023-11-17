package leet_code.collections.array
import java.lang.Double.max
/**
 * Given an array of points on the X-Y plane points where points[i] = [xi, yi], return the area of the largest triangle that can be formed by any three different points. Answers within 10-5 of the actual answer will be accepted.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * Output: 2.00000
 * Explanation: The five points are shown in the above figure. The red triangle is the largest.
 * Example 2:
 *
 * Input: points = [[1,0],[0,0],[0,1]]
 * Output: 0.50000
 * */

fun main() {
    println(
        largestTriangleArea(
            arrayOf(
                intArrayOf(0,0),
                intArrayOf(0,1),
                intArrayOf(1,0),
                intArrayOf(0,2),
                intArrayOf(2,0),

            )
        )
    )
}

fun largestTriangleArea(points: Array<IntArray>): Double {  // формула герона
    var ans = 0.0
    val n = points.size
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            for (k in j + 1 until n) {
                ans = max(
                    ans,
                    0.5 * Math.abs(points[i][0] * (points[j][1] - points[k][1]) + points[j][0] * (points[k][1] - points[i][1]) + points[k][0] * (points[i][1] - points[j][1]))
                )
            }
        }
    }
    return ans
}








