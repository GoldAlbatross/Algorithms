package leet_code.collections.linked_list
/**
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list
 * that has Node.val == val, and return the new head.
 *
 * Example 1:
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 * */
fun main() {
    val head = ListNode(1)
    val list = listOf(2,6,3,4,5,6)
    var t = head
    repeat(5) {
        t.next = ListNode(list[it])
        t = t.next!!

    }
    println(removeElements(head,6))
}


//======================================================================================================================
fun removeElements(head: ListNode?, `val`: Int): ListNode? {
    val newHead = ListNode(0)
    newHead.next = head

    var front = head
    var back = newHead

    while (front != null) {
        if (front.value == `val`) {
            back.next = front.next
        } else {
            back = back.next!!
        }
        front = front.next
    }

    return newHead.next
}