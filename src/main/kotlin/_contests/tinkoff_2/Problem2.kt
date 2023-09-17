package _contests.tinkoff_2

import java.util.*


private fun main() {

    val scanner = Scanner(System.`in`)

    var y = Int.MAX_VALUE
    val x: String = scanner.nextLine()
    val map = hashMapOf<Char, Int>()
    val str = "sheriff"

    x.forEach {
        map[it] = 1 + map.getOrDefault(it, 0)
    }

    str.forEach {
        val i = map[it]

        if (i != null) {
            if (y > i) y = i
        }
        else {
            println(0)
            return
        }
    }
    println( "${(map['f']!! / 2).coerceAtMost(y)}" )

}







//private fun main() {
//    val scanner = Scanner(System.`in`)
//    val sheriff: String = scanner.nextLine()
//    val regex = "[^sherif]".toRegex()
//    val replaced = sheriff.lowercase().replace(regex, "")
//    val map = replaced.groupingBy { it }.eachCount().toMutableMap()
//    map['f'] = map.getValue('f') / 2
//    println(map.values.min())
//}

