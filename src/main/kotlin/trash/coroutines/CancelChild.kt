package trash.coroutines

import kotlinx.coroutines.*

fun main() = runBlocking {

    launch {
        println("one")
        unknownFunction()
    }
    println("end")
}





suspend fun unknownFunction() {
    coroutineScope {
        launch(Job()) {
            println("three")
            delay(1000)
            println("forth")
        }
        println("cancel")
        cancel()
    }
}