package leet_code.collections.linked_list

fun main() {
    val l1 = ListNode(5)
    l1.tail = ListNode(6)
    l1.tail!!.tail = ListNode(7)

    val l2 = ListNode(3)
    l2.tail = ListNode(4)
    l2.tail!!.tail = ListNode(5)

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
            current.tail = l1
            l1 = l1.tail
        } else {
            current.tail = l2
            l2 = l2.tail
        }
        current = current.tail!!
    }

    current.tail = l1 ?: l2

    return result.tail
}

class ListNode(
    var value: Int
) {
    var tail: ListNode? = null
    override fun toString(): String {
        var next: ListNode? = this
        var result = next!!.value.toString()

        while (next != null) {
            result += next.tail?.value.toString()
            next = next.tail

        }
        return result
    }
}

