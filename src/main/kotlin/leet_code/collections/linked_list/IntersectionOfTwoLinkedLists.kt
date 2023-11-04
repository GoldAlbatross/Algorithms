package leet_code.collections.linked_list
/**
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
 * For example, the following two linked lists begin to intersect at node c1:
 *
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * Output: Intersected at '8'
 */
fun main() {
    val l1 = ListNode(4)
    l1.next = ListNode(2)
    l1.next!!.next = ListNode(3)

    val l2 = ListNode(1)
    l2.next = ListNode(2)
    l2.next!!.next = ListNode(3)

    println(getIntersectionNode(l1,l2))
}

//======================================================================================================================
fun getIntersectionNode(headA:ListNode?, headB:ListNode?):ListNode? {
    val set = mutableSetOf<ListNode?>()
    var pointer = headA
    while (pointer != null && set.add(pointer)) {
        pointer = pointer.next
    }
    pointer = headB
    while (pointer != null && set.add(pointer)) {
        pointer = pointer.next
    }
    return pointer
}