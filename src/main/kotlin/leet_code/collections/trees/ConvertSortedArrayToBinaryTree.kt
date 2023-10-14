package leet_code.collections.trees

private fun main() {

    sortedArrayToBST2(intArrayOf(-5,-4,-3,-2,0,2,3,4,5))
}
//======================================================================================================================
fun sortedArrayToBST2(nums: IntArray): TreeNode? {
    return buildTree(nums,0,nums.lastIndex, "start")
}
fun buildTree(nums: IntArray,start:Int,end:Int, str: String):TreeNode?{

    println("$str -> nums[$start]...nums[$end]")
    if(start>end) return null

    val mid = (start+end)/2
    println("val = ${nums[mid]}, mid = $mid\n")

    val node = TreeNode(nums[mid])
    node.left = buildTree(nums,start,mid-1, "left")
    node.right = buildTree(nums,mid+1,end, "right")
    return node
}
