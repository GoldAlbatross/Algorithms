package leet_code.collections.trees

import java.util.Stack

/**
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 *
 * Input: root = [1,null,2,3]
 * Output: [3,2,1]
 */
fun main() {
    val root = TreeNode(1)
    root.left = null
    root.right = TreeNode(2)
    root.right?.left = TreeNode(3)
    root.right?.left?.right = TreeNode(5)

    println(postorderTraversal(root))
}

fun postorderTraversal2(root: TreeNode?): List<Int> {
    val list = mutableListOf<Int>()
    val stack = Stack<TreeNode>()
    var current = root

    while (current != null || stack.isNotEmpty()) {
        current = if (current != null) {
            stack.push(current.left)
            list.add(current.`val`)
            current.right
        } else stack.pop()
    }

    return list.reversed()
}
//======================================================================================================================
fun postorderTraversal(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()

    fun postorder(node: TreeNode?) {
        if (node != null) {
            postorder(node.left)
            postorder(node.right)
            result.add(node.`val`)
        }
    }
    postorder(root)
    return result
}