package leet_code.collections.trees

import java.util.Stack

/**
Given the root of a binary tree, return the preorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,2,3]
*/

fun main() {
    val root = TreeNode(1)
    root.left = null
    root.right = TreeNode(2)
    root.right?.right = TreeNode(3)
    println(preorderTraversal(root))
}

fun preorderTraversal(root: TreeNode?): List<Int> {
    val list = mutableListOf<Int>()
    val stack = Stack<TreeNode>()
    var current = root

    while (current != null || !stack.isEmpty()) {
        current = if (current != null) {
            list.add(current.`val`)
            stack.push(current.right)
            current.left
        } else { stack.pop() }
    }
   return list
}