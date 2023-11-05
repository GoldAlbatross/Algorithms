package trash

import kotlinx.coroutines.*


import kotlinx.coroutines.*

suspend fun suspendFunction() {
    println("Starting suspendFunction")
    delay(100) // Симуляция долгой операции
    throw Exception()
    println("Finishing suspendFunction")
}

fun main() = runBlocking {

    val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        println("Coroutine failed with exception -> $exception")
    }

    val job = launch(exceptionHandler + SupervisorJob()) {
//        try {
//            suspendFunction()
//        } catch (e: Exception) {
//            println("Caught an exception: $e")
//        }

        //suspendFunction()
    }

    delay(500) // Подождем некоторое время

    job.cancel() // Отменяем корутину

    job.join() // Дожидаемся завершения корутины
}





//flow {
//    repeat(5) {
//        if (it == 3) throw AssertionError
//        emit("Значение $it")
//    }
//}.catch {
//    println("Ошибочка вышла")
//}.collect {
//    printin(it)
//}









