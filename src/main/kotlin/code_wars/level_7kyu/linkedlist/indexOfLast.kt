package code_wars.level_7kyu.linkedlist

class Node {
    var data: Any? = null
    var next: Node? = null
}
fun main() {

}

fun lastIndexOf(head: Node?, value: Any) =
    generateSequence(head) { it.next }.indexOfLast { it.data == value }


fun lastIndexOf1(head: Node?, value: Any): Int {
    var head = head
    var lastIndex = -1
    var i = 0

    while (head != null) {
        if (head.data == value) { lastIndex = i }
        head = head.next
        i++
    }

    return lastIndex
}