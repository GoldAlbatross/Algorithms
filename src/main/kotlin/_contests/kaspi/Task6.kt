package _contests.kaspi

import java.io.BufferedReader
import java.io.InputStreamReader
/*
ANDROID_UNIQUE
Дан массив чисел, где каждое число повторяется, кроме одного.
Найдите это уникальное число Пример: Входные параметры: [ 2, 2, 3, 1, 1]
Выходные параметры:
 */
fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val input = reader.readLine().split(",").map { it.trim().toInt() }
    val output = unique(input)
    println(output)
    reader.close()
}


fun unique(items: List<Int>) : Int {
    var res = items[0]
    for (i in 1 until items.size) {
        res = res xor items[i]
    }
    return res
}
