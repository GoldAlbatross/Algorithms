package leet_code.strings

/**
 * You are given a string s of even length. Split this string into two halves of equal lengths,
 * and let a be the first half and b be the second half.
 * Two strings are alike if they have the same number of vowels
 * ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.
 * Return true if a and b are alike. Otherwise, return false.
 *
 * Example 1:
 * Input: s = "book"
 * Output: true
 * Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.
 *
 * Example 2:
 * Input: s = "textbook"
 * Output: false
 * Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
 * Notice that the vowel o is counted twice.
 * */

fun main() {
    println(halvesAreAlike("textbook"))
}

fun halvesAreAlike(s: String): Boolean {
    var left = 0
    var right = 0

    s.take(s.length/2).forEach {
        if(catchVovel(it)) left++
    }

    s.takeLast(s.length/2).forEach {
        if(catchVovel(it)) right++
    }
    return left == right
}

fun catchVovel(c: Char): Boolean {
    return when(c) {
        'e','u','i','o','a' -> true
        'E','U','I','O','A' -> true
        else -> false
    }
}