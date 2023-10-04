package leet_code.collections.trees

import java.util.*

private fun main() {
    var t = TreeNode(3)
    t.left = TreeNode(9)
    t.right = TreeNode(20)
    t.right?.right = TreeNode(7)
    t.right?.left = TreeNode(15)
    t.right?.left?.right = TreeNode(16)

    println(maxDepth(t))
}

//======================================================================================================================
fun maxDepth(root: TreeNode?): Int {
    if (root == null) return 0
    return 1 + maxDepth(root.left).coerceAtLeast(maxDepth(root.right))
}