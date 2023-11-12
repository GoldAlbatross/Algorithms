package leet_code.collections.linked_list
/**
 *Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 *
 *Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 *
 * Example 2:
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 * */
fun main() {
    val solution = Solution()
    val head = ListNode(3)
    head.next = ListNode(2)
    head.next!!.next = ListNode(0)
    head.next!!.next!!.next = ListNode(-4)
//    head.next!!.next!!.next!!.next = head.next

    println(solution.middleNode(head))
}

class Solution {
    fun middleNode(head: ListNode?): ListNode? {

        var node = head
        val listNodes = mutableListOf<ListNode>()

        while(node != null) {
            listNodes.add(node)
            node = node.next
        }

        return listNodes[listNodes.size / 2]
    }
}

// пройти вглубь по всему списку до налл
// по ходу складывать все ноды в лист
// в конце проверить размер листа
// если 4 то вернуть 2
// если 3 то вернуть 2