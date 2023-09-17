package _contests.tinkoff_2

import java.util.Scanner


private fun main() {

    val scanner = Scanner(System.`in`)

    val size = scanner.nextLine().toInt()
    val inputData1 = scanner.nextLine()
    val inputData2 = scanner.nextLine()

    val currentSequence = IntArray(size)
    val target = IntArray(size)

    for (i in 0 until size) {
        currentSequence[i] = inputData1[i] - '0'
        target[i] = inputData2[i] - '0'
    }

    if (isSuccess(currentSequence, target)) println("YES") else println("NO")
}

private fun isSuccess(currentSequence: IntArray, target: IntArray): Boolean {

    var start = 0
    var end = 0

    val newSequence = mutableListOf<Int>()

    for (i in target.indices) {

        if (currentSequence[i] != target[i]) {
            start = i

            for (j in i until target.size) {
                newSequence.add(currentSequence[j])
                end = j
                if (j == target.size - 1 || target[j] > target[j + 1]) break
            }


            val x: IntArray = target.copyOfRange(start, end + 1).sortedArray()
            val y: IntArray = newSequence.toIntArray().sortedArray()

            if (y.contentEquals(x))  break
            else return false
        }
    }

    for (i in ++end..target.lastIndex) {
        if (currentSequence[i] != target[i]) {
            return false
        }
    }
    return true
}
