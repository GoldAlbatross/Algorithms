package code_wars.level_6kyu.arrays
/*
You are given an array (which will have a length of at least 3, but could be very large)
containing integers. The array is either entirely comprised of odd integers or
entirely comprised of even integers except for a single integer N.
Write a method that takes the array as an argument and returns this "outlier" N.
 */

fun main() {
 print(code_wars.level_6kyu.arrays.find(arrayOf(2, 6, 8, -10, 3)))

}
//----------------------------------------------------------------------------------------------------------------------
fun find(integers: Array<Int>): Int {
    val (a, b) = integers.partition { it % 2 == 0 }
    return if (a.size == 1)  a[0]
    else b[0]
}
//----------------------------------------------------------------------------------------------------------------------
fun find1(integers: Array<Int>) =
    integers.singleOrNull { it % 2 == 0 } ?: integers.single { it % 2 != 0 }
//----------------------------------------------------------------------------------------------------------------------

