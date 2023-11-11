package leet_code.collections.linked_list

/**
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 *
 * Example 1:
 * Input: head = [1,2,2,1]
 * Output: true
 *
 * Example 2:
 * Input: head = [1,2]
 * Output: false
 * */

fun main() {
    val l1 = ListNode(3)
    l1.next = ListNode(2)
    l1.next!!.next = ListNode(0)
    l1.next!!.next!!.next = ListNode(-4)
    l1.next!!.next!!.next!!.next = l1.next
    println(isPalindrome(l1))
}

fun isPalindrome(head: ListNode?): Boolean {
    val list = mutableListOf<Int>()
    var currentNode = head
    var start = 0

    while (currentNode != null) {
        list.add(currentNode.value)
        currentNode = currentNode.next
    }

    var end = list.lastIndex

    while (start < end) {
        if (list[start] == list[end]) {
            start++
            end--
        } else return false
    }
    return true
}



// [0]        v v
// [121]  ->  121

// [1221] -> 1221

// [321]

// [123]