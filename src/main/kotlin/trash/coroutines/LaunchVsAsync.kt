package trash.coroutines

import kotlinx.coroutines.*

fun main() = runBlocking {
    async {
        println("a")
        delay(1000)
        println("aa")
    }
    async {
        println("b")
        delay(100)
        println("bb")
    }
    launch {
        println("c")
        delay(100)
        println("cc")
    }
    launch {
        println("d")
        delay(100)
        println("dd")
    }
    println("end")

}


