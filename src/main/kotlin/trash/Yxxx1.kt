package trash

import kotlin.math.abs


fun main() {
    getResult("cats","xcats")
    getResult("cat","atc")
    getResult("cats","cast")

}

private fun getResult(str1: String, str2: String): Boolean {
    if (abs(str1.length - str2.length) > 1) return false

    val map = mutableMapOf<String, Int>()

    if (str1.length <= str2.length) {
        for (c in str2) {
            map[c.toString()] = map.getOrDefault(c.toString(), 0) + 1
        }
        println(map)
        for (c in str1) {
            if (map.getOrDefault(c.toString(), 0) > 0) {
                map[c.toString()] = map[c.toString()]!! - 1
                if (map[c.toString()] == 0) map.remove(c.toString())
            }
        }
        println("$map \n")
    }


    //if ()


    return false
}























