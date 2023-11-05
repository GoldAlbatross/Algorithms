package trash.coroutines

import kotlinx.coroutines.*

/** Умеет ловить все Throwable кроме CancellationException
 и не отменяет соседние корутины
 Явно заставляет обрабатывать ошибку в каждой корутине*/
private suspend fun main()  {
    unknownFunction3()
}

inline fun CoroutineScope.launchIO(
    crossinline action: suspend () -> Unit,
    crossinline onError: suspend (Throwable) -> Unit,
): Job {

    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        launch { onError.invoke(throwable) }
    }

    return this.launch(exceptionHandler + Dispatchers.IO) {
        action.invoke()
    }
}

suspend fun unknownFunction3() {
    try {
        supervisorScope {

            launchIO(
                action = {
                    println("Job1 start")
                    launchIO(
                        action = {
                            println("Job2 start")
                            delay(2000)
                            throw AssertionError()
                        },
                        onError = { println("Throwable in job 2") }
                    )
                    println("Job1 end")
                    throw AssertionError()
                },
                onError = { println("Throwable in job 1") }
            )

            launchIO(
                action = {
                    println("Job3 start")
                    suspendFunction2()
                },
                onError = { println("Throwable in job 3") }
            )

            delay(1000)
            println("end")
        }
    } catch (t: Throwable) {
        println("Throwable in supervisorScope: $t")
    }
}
//Job1 start
//Job1 end
//Job2 start
//Job3 start
//Starting suspendFunction
//Throwable in job 1
//Throwable in job 3
//end
//Throwable in job 2



suspend fun suspendFunction2() {
    println("Starting suspendFunction")
    delay(100) // Симуляция долгой операции
    throw Exception()
}
