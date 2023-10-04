package leet_code.collections.trees

private fun main() {
    val x = TreeNode(1)
    x.left = TreeNode(2)
    x.right = TreeNode(2)
    x.left?.right = TreeNode(3)
    x.right?.right = TreeNode(3)

}

private fun isSymmetric(root: TreeNode?): Boolean {
    val a = root?.left
    val b = root?.right
    return mirrorTree(a,b)

}

fun mirrorTree(a: TreeNode?, b: TreeNode?): Boolean {
    return when {
        a == null || b == null -> a == b
        a.`val` != b.`val` -> false
        else -> mirrorTree(a.left, b.right) && mirrorTree(b.left, a.right)
    }

}