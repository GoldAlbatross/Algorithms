package trash.coroutines

import kotlinx.coroutines.*

private suspend fun main()  {
    unknownFunction2()
}

suspend fun unknownFunction2() {

    try {
        supervisorScope {

            launch {
                try {
                    println("Job1 start")
                    cancel()
                    delay(100)
                } catch (e: CancellationException) {
                    println("CancellationException in job 1")
                    throw e // Обязательно, чтоб не нарушать structure concurrency
                } catch (e: Exception) {
                    println("Exception in job 1")
                }
            }

            launch {
                try {
                    println("Job2 start")
                    suspendFunction()
                } catch (e: Exception) {
                    println("Exception in job 2")
                }
            }

            delay(1000)
            println("end")
        }
    } catch (e: Exception) {
        println("Exception in supervisorScope")
    }



}

suspend fun suspendFunction() {
    println("Starting suspendFunction")
    delay(100) // Симуляция долгой операции
    println("Finishing suspendFunction")
    throw Exception()
}