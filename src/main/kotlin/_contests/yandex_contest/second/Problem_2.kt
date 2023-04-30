package _contests.yandex_contest.second

import java.io.BufferedReader
import java.io.File
import java.io.PrintWriter

private const val START = "APPLICATION_FINISHED_LAUNCHING"
private const val END = "APPLICATION_TERMINATED"
fun main() {

    val input = File("input.txt")
    val buff = BufferedReader(input.reader())
    val writer = PrintWriter(File("output.txt"))

    var nice = 0
    var uid = -1
    var blocked = false
    var starts = 0
    val n = buff.readLine().toInt()
    repeat(n) { when (buff.getBitOfLine()) {
            START -> {
                if (uid > 0) {
                    buff.readLine()
                    ++starts
                    blocked = true
                } else {
                    uid = buff.readLine().toInt()
                    ++starts
                }
            }
            END -> {
                if (uid == buff.readLine().toInt()) {
                    if (!blocked) {
                        uid = -1
                        ++nice
                    } else {
                        uid = -1
                        blocked = false
                    }
                } else Unit
            }
            else -> {
                buff.readLine()
                System.gc()
            }
        }
    }
    buff.close()

    if (nice == 0) writer.use { it.println(0) }
    else {
        val res = 100.0f * nice / starts
        writer.use {
            if (res == res.toInt().toFloat())
                it.println("%.1f".format(res))
            else
                it.println("%.6f".format(res).trimEnd('0'))
        }
    }
}

private fun BufferedReader.getBitOfLine(): String {
    val str = StringBuilder("")

    while (-1 != this.read().also { str.append(it.toChar()) }) {
        if (str[0] != 'A') {
            str.append(this.readLine())
            return ""
        } else if (str.length == 22 && str.toString() == END) {
            this.readLine()
            return str.toString()
        } else if (str.length == 30 && str.toString() == START) {
            this.readLine()
            return str.toString()
        }
    }

    return ""
}

//        else if (str.length == 30) {
//            val x = this.readLine()
//            return ""
//        }