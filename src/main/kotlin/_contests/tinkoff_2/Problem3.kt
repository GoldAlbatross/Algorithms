package _contests.tinkoff_2

import java.util.Scanner

/*
Ограничение времени 2 секунды Ограничение памяти 256 МБ
Перед ковбоем Джо выложены n карт со значениями а1, а2 , . . . , an
Он хочет получить выигрышную последовательность карт со значениями b1 , b2 , . . . , bn.

Ковбой может выбрать непрерывный отрезок карт в своей последовательности [l, r] (1 <= l <= r <= n)
и упорядочить карты в этом отрезке по неубыванию.
Например, если перед ковбоем лежат карты {3, 3, 2, 5, 1, 5},
он может выбрать отрезок (2, 5 и получить последовательность {3, 1, 2, 3, 5, 5}.
Получится ли у ковбоя Джо получить выигрышную последовательность с помощью применения вышеописанной операции
ровно один раз? Формат входных данных В первой строке дано целое число п (1 <= n <= 2 • 10^5) -
количество карт в последовательности. Во второй строке даны п целых чисел а1, а2, ..., а, (1 <= аi <= 10^9) -
последовательность ковбоя Джо. В третьей строке даны п целых чисел 6,, b2, . .., bn, (1 ≤ bi ≤ 10^9) -
выигрышная последовательность.
Формат выходных данных Выведите «YES» (без кавычек), если Джо может получить выигрышную последовательность,
иначе выведите «NO».
 */
private fun main() {

    val scn = Scanner(System.`in`)
    val n = scn.nextLine().toInt()
    val f = scn.nextLine()
    val s = scn.nextLine()
    val a = IntArray(n)
    val b = IntArray(n)
    for (i in 0 until n) {
        a[i] = f[i].digitToInt()
        b[i] = s[i].digitToInt()
    }
    val r = check(a,b)
    println(r)
}

 private fun check(a: IntArray, b: IntArray): String {
     val s: Int
     var f = 0
     val l1 = mutableListOf<Int>()
     for (i in b.indices) {
         if (a[i] != b[i]) {
             s = i
             for (j in i..b.lastIndex) {
                 l1.add(a[j])
                 f = j
                 if (j == b.size-1 || b[j] > b[j+1]) {
                     break
                 }
             }
             val l2 = b.copyOfRange(s, f+1).sorted()
             if (l1.sorted() == l2) {
                 break
             }
             else {
                 return "NO"
             }
         }
     }
     for (i in ++f..b.lastIndex) {
         if (a[i] != b[i]) {
             return "NO"
         }
     }
     return "YES"
 }


/*
7
1441753
4145738

3
321
124

5
14224
14422
 */

