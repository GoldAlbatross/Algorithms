package _contests.kaspi

import code_wars.level_7kyu.linkedlist.lastIndexOf
import trash.memory.checkPerformance
import java.util.*

/*
ANDROID_RECOMPOSITION
Дано предложение в следующем формате: Первая буква написана заглавными буквами.
Каждое слово в тексте разделяется одним пробелом. Задача состоит в том,
чтобы переставить слова в тексте таким образом, чтобы все слова были переставлены в порядке
возрастания их длины. Верните новый текст в соответствии с форматом, показанным выше.
Например: Входной параметр: Должность на позицию android разработчика.
Выходной параметр: На позицию android должность разработчика.
 */
fun main() {
    val startTime = System.currentTimeMillis()

    val input = java.lang.StringBuilder("")
    val arr = arrayListOf("hjhg", "jkf","rtryrue","jf","kfpd","ngnjvffg")
    repeat(5) {
        input.append("${arr[(0..5).random()]} ")
    }
    println(recomposition(input.toString()))

    checkPerformance(startTime)
}

fun recomposition(input: String): String {
    val words = input.trim().split(" ").sortedBy { it.length }
    val capitalizedWords = words.mapIndexed { index, word ->
        if (index == 0) word.capitalize() else word
    }
    return capitalizedWords.joinToString(" ")
}



