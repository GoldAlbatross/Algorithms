package leet_code.collections.trees

import java.util.*


private fun main() {
    var t = TreeNode(1)
    t.left = null
    t.right = TreeNode(2)
    t.right?.right = TreeNode(3)

    inorderTraversal(t)


}

private fun inorderTraversal(root: TreeNode?): List<Int> {
    val res = mutableListOf<Int>()

    var current = root
    val stack = Stack<TreeNode>()

    while(current != null || stack.size != 0) {
        while(current != null) {
            stack.push(current)
            current = current.left
        }
        current = stack.pop()
        res.add(current.`val`)
        current = current.right
    }
    println(res)
    return res
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}



