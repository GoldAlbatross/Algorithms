package leet_code.collections.sorted_array

fun main() {
    println(
        removeDuplicates(intArrayOf(0,0,1,1,1,2,2,3,3,4))
    )

}
//======================================================================================================================
fun removeDuplicates(nums: IntArray): Int {

    nums.distinct().let {
        it.forEachIndexed { index, i ->
            nums[index] = i
        }
        return it.size
    }
}