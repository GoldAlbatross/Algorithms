package leet_code.strings

import java.util.*


fun main() {
    println(
        isValid("{[]}()")
    )
}
//======================================================================================================================
private fun isValid2(s: String): Boolean {
    if (s == "") { return true }
    val simplified = s
        .replace("()", "")
        .replace("{}", "")
        .replace("[]", "")
    if (simplified == s) { return false }
    return isValid(simplified)
}
//======================================================================================================================

private fun isValid(s: String): Boolean {
    val stack = Stack<Char>()
    for (char in s) {
        when (char) {
            '(', '{', '[' -> stack.push(char)
            ')' -> if (stack.isEmpty() || stack.pop() != '(') return false
            ']' -> if (stack.isEmpty() || stack.pop() != '[') return false
            '}' -> if (stack.isEmpty() || stack.pop() != '{') return false
        }
    }
    return stack.isEmpty()
}
