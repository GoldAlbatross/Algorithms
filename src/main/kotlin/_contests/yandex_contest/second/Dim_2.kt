package _contests.yandex_contest.second


fun main() {
    val t = System.currentTimeMillis()
    val input = "input.txt"
    val output = "output.txt"
    val scanner = java.util.Scanner(java.io.File(input))
    val writer = java.io.PrintWriter(output)

    var uid = -1
    var allSessions = 0
    val n = scanner.nextInt()
    val booleanArray = BooleanArray(n) {
        when (scanner.next()){
            START -> { uid = scanner.nextInt(); allSessions++; true }
            END -> { uid != scanner.nextInt() }
            else -> true
        }
    }
    //println(booleanArray.contentToString())
    println(allSessions)
    var nice = 0



    if (nice == 0) println(0)
    else {
        val res = 100.0f * nice / allSessions
        if  (res == res.toInt().toFloat())
            println("%.1f".format(res))
        else
            println("%.6f".format(res).trimEnd('0'))
    }


    println("xxx")
    println(System.currentTimeMillis() - t)
    val memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
    println(memory / 1024)


}