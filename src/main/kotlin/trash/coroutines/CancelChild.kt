package trash.coroutines

import kotlinx.coroutines.*

suspend fun main()  {
    unknownFunction()
}





suspend fun unknownFunction() {
    coroutineScope {
        launch(Job()) {
            println("three")
            cancel()
            delay(1000)
            println("forth")
        }
        cancel()
        delay(2000)
        println("cancel")
    }
}