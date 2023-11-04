package leet_code.collections.linked_list

fun main() {
    val l1 = ListNode(5)
    l1.next = ListNode(6)
    l1.next!!.next = ListNode(7)

    val l2 = ListNode(3)
    l2.next = ListNode(4)
    l2.next!!.next = ListNode(5)

    println(
        mergeTwoLists(l1,l2).toString()
    )

}
//======================================================================================================================
fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    val result = ListNode(0)
    var current = result

    var l1 = list1
    var l2 = list2

    while (l1 != null && l2 != null) {
        if (l1.value < l2.value) {
            current.next = l1
            l1 = l1.next
        } else {
            current.next = l2
            l2 = l2.next
        }
        current = current.next!!
    }

    current.next = l1 ?: l2

    return result.next
}

class ListNode(
    var value: Int
) {
    var next: ListNode? = null
    override fun toString(): String {
        var next: ListNode? = this
        var result = next!!.value.toString()

        while (next != null) {
            result += next.next?.value.toString()
            next = next.next

        }
        return result
    }
}

