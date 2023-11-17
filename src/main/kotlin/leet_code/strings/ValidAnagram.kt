package leet_code.strings
/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 * */
fun main() {
    println(isAnagram("anagram","nagaram"))
}

fun isAnagram(s: String, t: String): Boolean {
    val sMap = hashMapOf<Char,Int>()
    val tMap = hashMapOf<Char,Int>()

    s.forEach {
        sMap[it] = sMap.getOrDefault(it, 0) + 1
    }

    t.forEach {
        tMap[it] = tMap.getOrDefault(it, 0) + 1
    }

    if (sMap.size != tMap.size) return false

    sMap.forEach {
        val sValue = sMap[it.key]!!
        val tValue = tMap[it.key] ?: 0
        if (sValue - tValue != 0) return false
    }

    return true
}

