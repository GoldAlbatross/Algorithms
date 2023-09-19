package leet_code.arrays


private fun main() {
    println(
        removeElement(nums = intArrayOf(3,2,2,3), `val` = 3)
    )
}

private fun removeElement(nums: IntArray, `val`: Int): Int {

    nums.filter { it != `val` }.let {
        it.forEachIndexed { index, i ->
            nums[index] = i
        }
        return it.size
    }
}
//======================================================================================================================
private fun removeElement2(nums: IntArray, `val`: Int): Int {

    var k = 0
    for (i in nums.indices){
        if(nums[i] != `val`){
            nums[k] = nums[i]
            ++k
        }
    }
    return k
}
