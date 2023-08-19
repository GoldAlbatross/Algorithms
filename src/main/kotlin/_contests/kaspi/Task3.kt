package _contests.kaspi

import java.io.BufferedReader
import java.io.InputStreamReader
/*
Необходимо реализовать алгоритм сжатия строки, состоящий только из символов а-я,
А-Я Если буква появляется один раз, то ее необходимо оставить без изменений.
В противном случае, к этой букве необходимо добавить число повторений
Например: Входной параметр: АДАДББВГГДА ДДУУФФФФФН
Выходной параметр: А462ВГ2ДА2Д2У2Ф5Н
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val input = reader.readLine().trim()
    val output = compression(input)
    println(output)
    reader.close()
}

fun compression(input: String) : String {
    val sb = StringBuilder()
    var count = 1
    var cursor = input[0]
    for (i in 1 .. input.lastIndex) {
        if (input[i] == cursor)  count++
        else {
            sb.append(cursor)
            if (count > 1) {
                sb.append(count)
                count = 1
                cursor = input[i]
            }
        }
    }
    sb.append(cursor)
    if (count > 1) sb.append(count)
    return sb.toString()
}