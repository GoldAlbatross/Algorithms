package trash.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.NonCancellable.cancel
import kotlinx.coroutines.NonCancellable.invokeOnCompletion
import java.io.FileNotFoundException

@OptIn(InternalCoroutinesApi::class)
fun main() = runBlocking {

    val ceh = CoroutineExceptionHandler { _, throwable ->
        println(throwable)
    }
    val scope = CoroutineScope(Job() + Dispatchers.IO)

    scope.launch {

        supervisorScope {

            launch {
                delay(600)
                println("333")
            }.invokeOnCompletion(onCancelling = true) { println("333 is cancelling") }

            launch(ceh) {
                coroutineScope {

                    launch {
                        delay(100)
                        throw Exception("111")
                    }.invokeOnCompletion(onCancelling = true) { println("111 is cancelling") }

                    launch {
                        delay(200)
                        println("222")
                    }.invokeOnCompletion(onCancelling = true) { println("222 is cancelling $it") }
                }
            }

            launch(ceh) {
                delay(400)
                throw Exception("333")
            }

        }
    }

    delay(1000)
}




