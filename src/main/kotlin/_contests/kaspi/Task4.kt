package _contests.kaspi

import java.io.BufferedReader
import java.io.InputStreamReader
/*
ANDROID_SWITCH
Необходимо поменять местами символы в строке согласно данным условиям: Все буквы и символы,
которые не являются русскими, остаются на том же месте Все русские буквы должны поменяться местами
Например: Входной параметр: А-бв-Ке-ЕАИд Выходной параметр: д-ИА-Ее-КвбА
 */
fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val input = reader.readLine().trim()
    val output = switch(input)
    println(output)
    reader.close()
}

fun switch(input: String): String {
    val sb = StringBuilder()

    val rus = input.filter { it in 'а'..'я' || it in 'А'..'Я' }
    val eng = input.filter { it !in 'а'..'я' && it !in 'А'..'Я' }

    var rusIndex = 0
    var engIndex = 0

    for (i in input.indices) {
        if (input[i] in 'а'..'я' || input[i] in 'А'..'Я') {
            sb.append(rus[rus.length - 1 - rusIndex])
            rusIndex++
        } else {
            sb.append(eng[engIndex])
            engIndex++
        }
    }

    return sb.toString()
}
