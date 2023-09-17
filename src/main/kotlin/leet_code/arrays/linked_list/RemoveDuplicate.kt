package leet_code.arrays.linked_list


private fun main() {

    val ln = ListNode(-1)
    ln.next = ListNode(0)
    ln.next?.next = ListNode(0)
    ln.next?.next?.next = ListNode(2)
    deleteDuplicates(ln)
}

private fun deleteDuplicates(head: ListNode?): ListNode? {
    if(head?.next == null) return head

    var ln = head
    while (ln?.next != null) {
        if(ln.num == ln.next?.num)
            ln.next = ln.next?.next
        else
            ln = ln.next
    }
    return head
}

class ListNode(
    var num: Int
) {

    var next: ListNode? = null

    override fun toString(): String {
        var next: ListNode? = this
        var result = next?.num.toString()

        while (next != null) {
            result += next.next?.num ?: ""
            next = next.next
        }
        return result

    }

}