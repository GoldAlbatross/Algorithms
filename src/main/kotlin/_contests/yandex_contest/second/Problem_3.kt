package _contests.yandex_contest.second

fun main() {
    val input = "input.txt"
    val output = "output.txt"
    val scanner = java.util.Scanner(java.io.File(input))
    val writer = java.io.PrintWriter(output)


    val time = scanner.nextInt()
    val capacity = scanner.nextInt()
    val list = IntArray(capacity) {scanner.nextInt()}


    val x = list.toMutableList()
    println(x)
    var index = 0


    val pair = startSum(list)
    var leftTime = 0
    var rightTime = pair.second
    var resSum = (time * 1) + rightTime


    for (i in 1..list.size) {
        leftTime += list[i-1] * i
        val curTime = time * (i+1)
        rightTime -= list[i-1] * (i+1)
        val curRes = leftTime + curTime + rightTime
        if (curRes > resSum) {
            index = i
            resSum = curRes
        }
        println("leftTime:$leftTime  curTime:$curTime  rightTime:$rightTime  result:$resSum")
    }


    x.add(index,time)
    println(x)
    print(resSum - pair.first)
    writer.use { it.print(resSum - pair.first) }
}

private fun startSum(list: IntArray): Pair<Int,Int> {
    var sum = 0
    var shiftSum = 0
    for (i in 0..list.lastIndex) {
        sum += list[i] * (i+1)
        shiftSum += list[i] * (i+2)
    }
    return Pair(sum,shiftSum)
}

