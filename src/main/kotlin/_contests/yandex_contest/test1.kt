package _contests.yandex_contest

import java.io.File
import java.io.PrintWriter
import java.util.Scanner

fun main() {
    val pathIn = "C:\\Users\\Albatross\\yandex_contest\\file_1.txt"
    val pathOut = "C:\\Users\\Albatross\\yandex_contest\\file_2.txt"

    val scn = Scanner(File(pathIn))
    val out = PrintWriter(pathOut)

    val a = scn.nextInt()
    val b = scn.nextInt()

    val list = arrayListOf<Int>()
    while (scn.hasNext()) {
        list.add(scn.nextInt() + 3)
    }

    out.use {
        it.println("${a + 3} \n$b \n$list")
        it.println("done")
    }


}