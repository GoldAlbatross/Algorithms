package _contests.yandex_contest.second


const val START = "APPLICATION_FINISHED_LAUNCHING"
const val END = "APPLICATION_TERMINATED"
fun main() {
    val t = System.currentTimeMillis()
    val input = "input.txt"
    val output = "output.txt"
    val scanner = java.util.Scanner(java.io.File(input))
    val writer = java.io.PrintWriter(output)

    val n = scanner.nextInt()
    var allSessions = 0
    var nice = 0
    var uid = -1
    var str = ""
    var end = ""


    while (scanner.hasNext()) {
        str = scanner.next()
        if (str.length == 30 && str == START) {
            allSessions++
            if (scanner.hasNext()) uid = scanner.nextInt()
            var flag = true
            while (scanner.hasNext()) {
                end = scanner.next()
                if (end.length == 22 && end == END && flag) {
                    if (scanner.hasNext() && uid == scanner.nextInt()) {
                        nice++
                        break
                    }
                } else if (end.length == 30 && end == START) {
                    allSessions++
                    flag = false
                } else if (end.length == 22 && end == END) {
                    if (scanner.hasNext() && uid == scanner.nextInt())
                        break
                }
            }
        }

    }

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