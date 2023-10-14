package leet_code.collections.trees

import java.util.*
//Given the root of a binary tree and an integer targetSum, return true
// if the tree has a root-to-leaf path such that adding up all the values
// along the path equals targetSum.
//
//A leaf is a node with no children.
fun main() {
    var root = TreeNode(1)
    root.left = TreeNode(5)
    root.right = TreeNode(2)
    root.right?.right = TreeNode(6)


    println(hasPathSum(root,8))
}

fun hasPathSum2(root: TreeNode?, targetSum: Int): Boolean {

    var current = root
    val stack = Stack<TreeNode>()
    while (current != null || stack.size != 0) {
        while (current != null) {
            stack.push(current)
            current = current.left
        }
        if (targetSum == stack.sumOf { it.`val` }) return true
        current = stack.pop()
        current = current.right
    }
    return false
}

//======================================================================================================================
fun hasPathSum3(root: TreeNode?, sum: Int): Boolean {
    if (root==null){
        return false
    }
    else if (root.left == null && root.right == null
        && root.`val` == sum){
        return true
    }
    return hasPathSum(root.left, sum-root.`val`) || hasPathSum(root.right, sum-root.`val`)
}
//======================================================================================================================
fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    root?.let {
        return (it.left == null && it.right == null && it.`val` == targetSum)
                || hasPathSum(it.left, targetSum - it.`val`)
                || hasPathSum(it.right, targetSum - it.`val`)
    } ?: return false
}