package leet_code.collections.linked_list



fun main() {
    val l1 = ListNode(3)
    l1.tail = ListNode(2)
    l1.tail!!.tail = ListNode(0)
    l1.tail!!.tail!!.tail = ListNode(-4)
    l1.tail!!.tail!!.tail!!.tail = l1.tail
    println(hasCycle(l1))
}

fun hasCycle2(head: ListNode?): Boolean {
    var node = head
    var size = 0
    val set = hashSetOf<Int>()
    while (node != null && set.size == size) {
        size++
        set.add(node.hashCode())
        println("$size, $set")
        node = node.tail
    }

    return set.size == size
}
//======================================================================================================================
fun hasCycle(head: ListNode?): Boolean {
    val sentinel = 100000
    var current = head
    while (current != null && current.value != sentinel) {
        current.value = sentinel
        current = current.tail
    }

    return current != null
}