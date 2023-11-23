package trash.coroutines

import kotlinx.coroutines.*
import kotlin.math.log
import kotlin.system.measureTimeMillis

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun main() {
    var counter = 0
    //val singleThreadContext = newSingleThreadContext("1")

    val time = measureTimeMillis {
        withContext(Dispatchers.Default.limitedParallelism(1)) {
            repeat(100) {
                launch {
                    repeat(1000) {
                        counter++
                    }
                }
            }
        }
    }

    println("the end!   counter=$counter   time=$time")
}