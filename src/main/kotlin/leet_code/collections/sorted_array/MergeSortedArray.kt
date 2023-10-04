package leet_code.collections.sorted_array

private fun main() {
    val ar1 = intArrayOf(1,2,3,0,0,0)
    val ar2 = intArrayOf(0,1,2)

    merge2(ar1,3,ar2,3)

}

private fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    for (i in 0..nums2.lastIndex) {
        nums1[i+m] = nums2[i]
    }
    nums1.sort()
}
//======================================================================================================================

private fun merge2(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var i = m - 1
    var j = n - 1
    var k = m + n -1
    while (j >= 0) {
        nums1[k--] =
            if (i < 0 || nums1[i] < nums2[j])
                nums2[j--]
            else
                nums1[i--]
    }
}