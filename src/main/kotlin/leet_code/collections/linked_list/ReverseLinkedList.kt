package leet_code.collections.linked_list

import java.util.Stack

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * */
fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(3)
    head.next?.next?.next = ListNode(4)
    head.next?.next?.next?.next = ListNode(5)



    println(reverseList(head))
}

fun reverseList2(head: ListNode?): ListNode? {
    val stack = Stack<ListNode>()
    var cHead = head

    while (cHead != null) {
        stack.push(cHead)
        cHead = cHead.next
    }

    if (stack.isEmpty()) { return null }
    val newHead = stack.pop()
    var current = newHead

    while (stack.isNotEmpty()) {
        current.next = stack.pop()
        current = current.next
    }

    current.next = null

    return newHead
}

//======================================================================================================================

fun reverseList3(head: ListNode?): ListNode? {
    var cHead: ListNode? = head
    var newList: ListNode? = null

    while (cHead != null) {
        val tail = cHead.next
        cHead.next = newList
        newList = cHead
        cHead = tail
        println(newList)
    }

    return newList
}

/**==================================Perfect==========================================================================*/
fun reverseList(head: ListNode?): ListNode? {
    return recursive(head, null)
}

fun recursive(current: ListNode?, newHead: ListNode?): ListNode? {

    if (current == null) return newHead
    val tail = current.next
    current.next = newHead

    return recursive(tail, current)
}