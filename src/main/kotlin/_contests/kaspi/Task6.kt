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
//======================================================================================================================
fun unique2(items: List<Int>) : Int {
    var res = 0
    for (i in 1 until items.size) {
        res = res xor items[i]
        println(res)
    }
    return res
}
//======================================================================================================================
private fun unique(items: List<Int>) : Int {
    val map = hashMapOf<Int,Int>()
    for (num in items) {
        map[num] = 1 + map.getOrDefault(num,0)
    }
    val res = map.filter { it.value == 1 }
    return res.keys.first()
}
