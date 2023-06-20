package leet_code.numbers

/*
Перевести Римские цифры в Int
*/
fun main() {
    println(romanToInt("MCMXCIV"))
}
//======================================================================================================================
private fun romanToInt(s: String): Int {
    var result = 0
    for (i in 0..s.lastIndex) {
        val char = if (i != s.lastIndex) s[i+1] else 0
        result += when (s[i]) {
            'M' -> 1000
            'D' -> 500
            'C' -> if (char == 'D' || char == 'M') -100 else 100
            'L' -> 50
            'X' -> if (char == 'L' || char == 'C') -10 else 10
            'V' -> 5
            'I' -> if (char == 'V' || char == 'X') -1 else 1
            else -> 0
        }
    }
    return result
}