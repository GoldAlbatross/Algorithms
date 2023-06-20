package trash.sprint_7

import java.util.*

abstract class BaseStructure<K, V> {
    val scan = Scanner(System.`in`)
    abstract var list: MutableMap<K, V>
    private var index: Int = 0

    companion object {
        internal const val THIS = "this"
        internal const val THE_END = "the_end"
    }

    open fun showList() {
        var i = 0
        list.forEach { (key,_) -> println("${++i}. $key") }
        println("${++i}. Выход")
        index = i
    }

    fun inputHandler(input: Int): String {
        return when (input) {
            0 -> { println("Введите название")
                addItem(scan.nextLine())
                THIS }
            in 1 until index -> getKey(input)
            index -> THE_END
            else -> {println("ошибка ввода!")
                THIS
            }
        }
    }

    abstract fun addItem(s: String)

    private fun getKey(input: Int): String {
        var key = ""
        var i = 0
        for (e in list)
            if (++i == input) key = e.key.toString()
        return key
    }
}