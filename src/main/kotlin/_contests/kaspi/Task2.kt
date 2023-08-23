package _contests.kaspi

import java.io.BufferedReader
import java.io.InputStreamReader
/*
ANDROID_ANAGRAM
Напишите функцию, которая принимает на вход две строки и проверяет,
являются ли они анаграммами (т.е. содержат ли они одинаковое количество одинаковых символов
Функция должна возвращать true, если строки являются анаграммами, и faise в противном случае.
Пример: Входные параметры: listen, silent Выходные параметры: true
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val input = reader.readLine().split(",").map { it.trim() }
    val output = anagram2(input[0], input[1])
    println(output)
    reader.close()
}
//======================================================================================================================
private fun anagram(firstString: String, secondString: String) : Boolean {
    val arr1 = firstString.toCharArray().sorted()
    val arr2 = secondString.toCharArray().sorted()
    return arr1 == arr2
}
//======================================================================================================================
private fun anagram2(str1: String, str2: String): Boolean {
    if (str1.length != str2.length) return false

    val map = mutableMapOf<Char, Int>()

    for (char in str1)
        map[char] = 1 + map.getOrDefault(char, 0)

    for (char in str2) {
        if (map.containsKey(char)) {
            map[char] = map[char]!! - 1
            if (map[char] == 0) {
                map.remove(char)
            }
        } else return false
    }

    return map.isEmpty()
}

