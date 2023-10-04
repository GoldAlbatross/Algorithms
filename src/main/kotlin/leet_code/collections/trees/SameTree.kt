package leet_code.collections.trees

import java.util.*

private fun main() {

}

private fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    val listP = mutableListOf<Int?>()
    val listQ = mutableListOf<Int?>()

    var currentP = p
    var currentQ = q

    val stackP = Stack<TreeNode>()
    val stackQ = Stack<TreeNode>()

    while (currentP != null || stackP.size != 0) {
        while (currentP != null) {
            stackP.push(currentP)
            listP.add(currentP.`val`)
            currentP = currentP.left
        }
        listP.add(null)
        currentP = stackP.pop()
        listP.add(currentP.`val`)
        currentP = currentP.right
    }

    while (currentQ != null || stackQ.size != 0) {
        while (currentQ != null) {
            stackQ.push(currentQ)
            listQ.add(currentQ.`val`)
            currentQ = currentQ.left
        }
        listQ.add(null)
        currentQ = stackQ.pop()
        listQ.add(currentQ.`val`)
        currentQ = currentQ.right
    }
    return listP == listQ
}
//======================================================================================================================

private fun isSameTree2(p: TreeNode?, q: TreeNode?): Boolean {
    return when {
        p == null || q == null -> p == q
        p.`val` != q.`val` -> false
        else -> isSameTree(q.left, p.left) && isSameTree(q.right, p.right)
    }
}