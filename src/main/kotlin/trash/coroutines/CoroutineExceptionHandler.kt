package trash.coroutines

import kotlinx.coroutines.*

@OptIn(InternalCoroutinesApi::class)
fun main() = runBlocking {

    val eHandler = CoroutineExceptionHandler { _, throwable ->
        println(throwable)
    }
    val scope = CoroutineScope(Job() + Dispatchers.IO + eHandler)

    scope.launch {

        supervisorScope {

            launch(eHandler) {
                delay(600)
                println("333")
            }

            launch(eHandler) {// в этой точке eHandler поймает throw Exception("111")

                coroutineScope {

                    launch {
                        delay(100)
                        throw Exception("111")
                    }

                    launch {
                        delay(200)
                        println("222")
                    }.invokeOnCompletion { println("222 is cancelling") }
                }
            }

            launch(eHandler) {// в этой точке eHandler поймает throw Exception("444")
                delay(400)
                throw Exception("444")
            }

        }
    }

    delay(1000)
}




