package leet_code.collections.array
/**
 * Example 1:
 *
 * Input
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * Output
 * [null, 4, 5, 5, 8, 8]
 *
 * Explanation
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 * */
fun main() {
    val test = KthLargest(3, intArrayOf(4,5,8,2))
    println(test.add(3))
    println(test.add(5))
    println(test.add(10))
    println(test.add(9))
}
class KthLargest(val k: Int,nums: IntArray) {

    var arr = nums.sorted().takeLast(k)
    fun add(`val`: Int): Int {
        arr = (arr +`val`).sorted().takeLast(k)
        return arr[0]
    }
}

// v
// 4 5 8 2 + 3            3  -> 4

//   v
// 4 5 8 2 3 + 5          5  -> 5

//   v
// 4 5 8 2 3 5 + 10       10 -> 5

//     v
// 4 5 8 2 3 5 10 + 9     9  -> 8

//     v
// 4 5 8 2 3 5 10 9 + 4   4  -> 8


// создаем лист из трех последних значений после сортировки  458
// добавляем все что больше или равно этим числам           558, 5810, 8910
// после добавления режем список и соритируем
// берем первый элемент