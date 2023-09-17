package _contests.tinkoff_2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.HashSet
import java.util.StringTokenizer

/*

Ограничение времени 2 секунды Ограничение памяти 256 МБ
Однажды ковбой Джо забрёл в жуткую заброшенную шахту, в которой обитают n духов с номерами 1,2, • .. n.
Сейчас каждый дух состоит в банде из самого себя. В один момент времени каждый дух может находиться ровно в одной банде.
По одиночке духи слабы, поэтому вскоре банды начнут объединяться. Когда две банды объединяются,
создаётся новая банда, в которую попадают все духи из объединяющихся банд, в то время как старые банды распадаются.
Ковбоя Джо оглушил душераздирающий крик, который сообщил ему о необходимости ответить на m вопросов.
Если ковбой Джо откажется отвечать на вопросы крика или ошибётся, то навечно сгинет в заброшенной шахте.
Дух задаст m вопросов, каждый из которых относится к одному из трёх типов. •
1) Духи x и y объединяются в банду.
Если они уже находятся в одной банде, ничего не происходит.
2) Крик спрашивает ковбоя Джо, находятся ли духи x и y в одной банде.
3) Крик спрашивает ковбоя Джо, в скольких бандах побывал дух x.
Например, если n = 7, а банды выглядели так: [1, 3], [4, 6, 2], [5], [7],
и крик сообщил об объединении банд с духами 1 и 5, банды будут выглядеть так: [1,5, 3], [4, 6, 2], [7].
Духи 1, 3, 5 побывали в двух бандах,духи 2, 4, 6, 7 в одной.

Формат входных данных:
В первой строке даны целые числа n, m (1 <= n, m <= 2 * 10^5) - количество духов и вопросов крика.
Следующие m строк содержат описание вопросов:
 • 1xy (1 <= x, y <= n)
 • 2xy (1 <= x, y <= n)
 • 3x (1 <= x <=n )
Формат выходных данных:
Для каждого вопроса второго типа выведите "YES" или "NO" (без кавычек).
Для каждого вопроса третьего типа выведите целое число - ответ на вопрос.
*/

/*
7 13
2 3 1
3 3
1 2 4
2 1 1
3 4
2 3 4
1 3 4
3 4
1 7 3
1 1 3
3 7
3 1
2 7 4
*/


private fun main() {

    val reader = BufferedReader(InputStreamReader(System.`in`))
    val tokenizer = StringTokenizer(reader.readLine())
    val n = tokenizer.nextToken().toInt()
    val m = tokenizer.nextToken().toInt()

    val groups = Item(n)

    val output = mutableListOf<String>()

    repeat(m) {
        val query = reader.readLine().split(" ")

        when (query[0]) {
            "1" -> {
                val x = query[1].toInt()
                val y = query[2].toInt()
                groups.createGroup(x, y)
            }

            "2" -> {
                val x = query[1].toInt()
                val y = query[2].toInt()
                if (groups.checkGroup(x, y)) output.add("YES")
                else output.add("NO")
            }

            "3" -> {
                val x = query[1].toInt()
                output.add(groups.count(x).toString())
            }
        }
    }

    output.forEach { println(it) }
}

private class Item(private val n: Int) {

    private val hashMap = HashMap<Int, Int>()
    private val arr = ArrayList<HashSet<Int>>()

    init {
        for (i in 1..n) {
            hashMap[i] = 1
            arr.add(hashSetOf(i))
        }
    }

    fun createGroup(x: Int, y: Int) {
        if (!checkGroup(x, y)) {
            for (i in arr[x-1]) {
                arr[i-1] += arr[y-1]
            }
            arr[y-1] += arr[x-1]
            for (i in arr[y-1]) {
                arr[i-1] += arr[y-1]
                hashMap[i] = hashMap[i]!! + 1
            }
        }
    }

    fun checkGroup(x: Int, y: Int): Boolean {
        return arr[x-1] == arr[y-1]
    }

    fun count(x: Int): Int {
        return hashMap[x]!!
    }
}