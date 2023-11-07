package leet_code.strings
/**
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 * */
fun main() {
    println(isIsomorphic(s = "badc", t = "baba"))
}

fun isIsomorphic2(s: String, t: String): Boolean {

    if (s.length != t.length) return false

    val map = hashMapOf(s[0] to t[0])

    for (i in 0..s.lastIndex) {
        if (map.containsKey(s[i])) {
            if (map[s[i]] != t[i]) return false
        } else {
            if (map.containsValue(t[i])) return false
            map[s[i]] = t[i]
        }

    }

    return true
}
/**=======================Perfectly===================================================================================*/
fun isIsomorphic(s: String, t: String): Boolean {
    val (sGroup, tGroup) = List(2) { mutableMapOf<Char, Int>() }
    return s.indices.all { i ->
        val a = sGroup.put(s[i], i)
        val b = tGroup.put(t[i], i)
        a == b
    }
}