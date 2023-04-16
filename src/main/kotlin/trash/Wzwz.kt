package trash

import _contests.yandex_contest.second.END
import _contests.yandex_contest.second.START
import java.io.PrintWriter



fun main() {


    val out = PrintWriter("input.txt")
    out.use {it ->
        it.println(1000000)
        repeat(500000) { _ ->
            it.println(START)
            it.println((211..212).random())
            it.println(END)
            it.println((211..212).random())
        }
    }



}





