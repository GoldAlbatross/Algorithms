package trash.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

@OptIn(InternalCoroutinesApi::class)
fun main() = runBlocking {
    val mutex = Mutex()
    var counter = 0

    val owner1: (Int) -> Unit = { println("job1: $counter") }
    val owner2: (Int) -> Unit = { println("job2: $counter") }

    coroutineScope {
        val job1 = launch {
            repeat(10) {
                if (counter == 3) { throw CancellationException() }
                delay(30)
                mutex.withLock(owner1) {
                    owner1(counter++)
                }
            }
        }.invokeOnCompletion(onCancelling = true) { throwable ->
            println("error: ${throwable?.message ?: "unknown"}")
        }

        val job2 = launch {
            repeat(20) {
                delay(90)
                mutex.withLock(owner2) {
                    owner2(counter--)
                }
            }
        }
    }



    delay(2000)
    println("Counter: $counter")
}
