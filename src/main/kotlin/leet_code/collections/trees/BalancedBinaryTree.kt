package leet_code.collections.trees

import java.util.*
import kotlin.math.abs

/*Given a binary tree, determine if it is height-balanced*/
private fun main() {
    var root = TreeNode(1)
    root.left = TreeNode(-1)
    root.right = TreeNode(2)
    root.right?.right = TreeNode(3)
    //root.right?.right?.right = TreeNode(4)

    println(isBalanced(root))
}

fun isBalanced(root: TreeNode?): Boolean {
    return checkBalanced(root) != -1
}

private fun checkBalanced(node: TreeNode?): Int {
    if (node == null) return 0

    val leftHeight = checkBalanced(node.left)
    val rightHeight = checkBalanced(node.right)

    if (leftHeight == -1 || rightHeight == -1 || abs(leftHeight - rightHeight) > 1) {
        return -1
    }

    return 1 + leftHeight.coerceAtLeast(rightHeight)
}
