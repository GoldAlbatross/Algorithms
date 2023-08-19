package _contests.kaspi

fun compressString(input: String): String {
    val compressedStringBuilder = StringBuilder()
    var currentChar = input[0]
    var charCount = 1

    for (i in 1 until input.length) {
        if (input[i] == currentChar) {
            charCount++
        } else {
            compressedStringBuilder.append(currentChar)
            if (charCount > 1) {
                compressedStringBuilder.append(charCount)
            }
            currentChar = input[i]
            charCount = 1
        }
    }

    compressedStringBuilder.append(currentChar)
    if (charCount > 1) {
        compressedStringBuilder.append(charCount)
    }

    return compressedStringBuilder.toString()
}

fun main() {
    val input = "АДАДББВГГДА ДДУУФФФФФН"
    val compressedString = compressString(input)
    println(compressedString) // Output: А462ВГ2ДА2Д2У2Ф5Н
}
