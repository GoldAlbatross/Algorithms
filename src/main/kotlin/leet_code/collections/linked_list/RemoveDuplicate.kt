package leet_code.arrays.linked_list


private fun main() {

    val ln = ListNode1(-1)
    ln.next = ListNode1(0)
    ln.next?.next = ListNode1(0)
    ln.next?.next?.next = ListNode1(2)
    deleteDuplicates(ln)
}

private fun deleteDuplicates(head: ListNode1?): ListNode1? {
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

class ListNode1(
    var num: Int
) {

    var next: ListNode1? = null

    override fun toString(): String {
        var next: ListNode1? = this
        var result = next?.num.toString()

        while (next != null) {
            result += next.next?.num ?: ""
            next = next.next
        }
        return result

    }

}