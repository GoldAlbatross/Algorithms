package leet_code.strings
/**
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors.
 * '#' means a backspace character.
 * Note that after backspacing an empty text, the text will continue empty.
 *
 *
 * Example 1:
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 *
 * Example 2:
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 *
 * Example 3:
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 * */
//    V           V
// "ab#c", t = "ads##c"
fun main() {
    println(backspaceCompare("a#c", "b"))
}

fun backspaceCompare(s: String, t: String): Boolean {
    return clearText(s) == clearText(t)
}

fun clearText(s: String): String {
    return buildString {
        for (c in s) {
            if (c == '#') {
                if (isNotEmpty())
                    setLength(length-1)
            } else
                append(c)
        }
    }
}
