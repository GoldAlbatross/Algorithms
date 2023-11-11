package leet_code.collections.trees

// Given a binary tree, find its minimum depth.
fun main() {
    var root = TreeNode(1)
    root.left = TreeNode(-1)
    root.right = TreeNode(2)
    root.right?.right = TreeNode(3)

    val x = Solution()
    println(x.minDepth(root))
}

class Solution {
    fun minDepth(root: TreeNode?): Int {
        if (root == null) return 0
        val left = minDepth(root.left)
        val right = minDepth(root.right)
        return if (left == 0 || right == 0)
            left + right + 1
        else left.coerceAtMost(right) + 1
    }
}

