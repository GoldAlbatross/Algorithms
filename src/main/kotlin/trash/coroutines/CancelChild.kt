package trash.coroutines

import kotlinx.coroutines.*

private suspend fun main()  {
    unknownFunction()
}


suspend fun unknownFunction() {
    coroutineScope {
        val job = launch(Job()) {
            println("three")
            cancel()
            delay(1000)
            println("forth")
        }
        job.ensureActive()
        cancel()
        delay(2000)
        println("cancel")
    }
}