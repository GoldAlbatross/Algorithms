package trash

import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException
import java.io.PrintWriter


private const val START = "APPLICATION_FINISHED_LAUNCHING"
private const val END = "APPLICATION_TERMINATED"

fun main() {


    val out = PrintWriter("input.txt")
    out.use {
        it.println(20)
        repeat(20) { _ ->
            it.print("${(1..30).random()} ")
            it.print("${(1..40).random()} ")
//            it.println("qwertyuiopasdfghjaaa".repeat(100) + "\n111")
//            it.println("aaaa_bbbb\n111")
//            it.println("$END\n${(211..212).random()}")
        }
    }

    try {
        val reader = BufferedReader(FileReader("file.txt"))
        val line = reader.readLine()
        println(line)
        reader.close()
    } catch (e: IOException) {
        e.printStackTrace()
    }



}





