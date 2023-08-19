package _contests.kaspi

import java.io.BufferedReader
import java.io.InputStreamReader
/*
ANDROID_TARGET_SUM
Дан массив чисел и целевое число target. Найдите два числа в массиве, сумма которых равна target.
Верните их индексы в виде массива. Пример: Входные параметры: target - 9 [2, 5, 7, 1, 3]
Выходные параметры: [0, 2]
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val input = reader.readLine().trim()
    val params = input.split(";")
    val target = params[0].trim().toInt()
    val numbers = params[1].split(",").map { it.trim().toInt() }
    val output = targetSum(target, numbers)
    println(output)
    reader.close()
}


fun targetSum(target: Int, numbers: List<Int>) : List<Int>{
    val map = HashMap<Int, Int>()
    for (i in numbers.indices) {
        map[numbers[i]] = i
    }
    for (i in numbers.indices) {
        val compliment = target - numbers[i]
        if (map.containsKey(compliment) && map[compliment] != i)
            return listOf(i, map[compliment]!!)
    }
    return emptyList()
}
