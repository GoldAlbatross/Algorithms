package code_wars.level_7kyu.linkedlist

class LinkedList<T: Any> {
    private var head: Node<T>? = null
    private var size = 0

    private fun isEmpty(): Boolean = size == 0

    override fun toString(): String {
        return if (isEmpty()) "Empty list"
        else head.toString()
    }

    fun push(value: T) {
        head = Node(data = value, next = head)
        size++
    }

    data class Node<T>(
        var data: T,
        var next: Node<T>? = null
    ){
        override fun toString(): String {
            return if (next != null) { "($data, next) -> $next" }
            else {"($data, null)"}
        }
    }
}

fun main() {
    val list = LinkedList<Any>()
    list.push(1)
    list.push(2)
    list.push(3)
    list.push(4)
    println(list)
}