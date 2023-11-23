package trash.coroutines

import kotlinx.coroutines.*
import java.io.PrintWriter

private suspend fun main()  {
    //unknownFunction2()

    sampleA2()
    delay(3000)
    println("program completed successfully")
}
val eH = CoroutineExceptionHandler { _,e -> println("eHandler: ${e.message}") }
var count = 0
fun writeListToFile() {
    val writer = PrintWriter("output.txt")
    val list = mutableListOf<Int>()
    repeat(9000000) {
        list.add(it+1)
    }
    writer.use {
        it.print(list)
    }
}


// Igor 8-  2+
// Rita



suspend fun sampleA() {//-
    coroutineScope {
        try {
            launch {
                throw Exception()
            }
        }catch (e: Exception) {
            println("catch")
        }finally {
            println("finally")
        }
    }
//===============================================================
    fun answer() {
// finally
// crash app
    }

}



suspend fun sampleA1() {//-
    supervisorScope {
        launch {
            try {
                throw Exception("task1")
            }catch (e: Exception) {
                println("catch: ${e.message}")
            }finally {
                println("finally")
            }
        }
    }
//===============================================================
fun answer() {
// catch: task1
// finally
// program completed successfully
}

}

// val a = async {}
// val b = async {}

// val list = List(80) { a.await(),b.await() }
// val list = mutableListOf()
// list.run {
// add(a.await()
//     add(b.await())
// }


suspend fun sampleA2() { //-
    supervisorScope {
        launch {
            throw Exception("task1")
        }
        launch {
            delay(100)
            println("task2")
        }
    }
//===============================================================
fun answer() {
// task2
// Exception in thread "DefaultDispatcher-worker-1" java.lang.Exception: task1
// program completed successfully
}

}



suspend fun sampleA3() { //-
    coroutineScope {
        launch {
            val writer = PrintWriter("output.txt")
            val list = mutableListOf<Int>()
            repeat(9000000) {
                list.add(it+1)
            }
            writer.use {
                it.print(list)
            }
            println("task2")
        }
        launch {
            throw Exception("task2")
        }
    }
//===============================================================
fun answer() {
// task2 (файл полностью записался)
// Exception in thread "DefaultDispatcher-worker-1" java.lang.Exception: task2
}

}



suspend fun sampleA4() { //-
    supervisorScope {
        launch {
            launch {
                throw Exception("task1")
            }
            delay(100)
            println("task1.1")
        }
        launch {
            delay(200)
            println("task2")
        }
    }
//===============================================================
fun answer() {
// Exception in thread "DefaultDispatcher-worker-1" java.lang.Exception: task1
// task2
// program completed successfully
}

}



suspend fun sampleB() { //-
    try {
        supervisorScope {
            launch {
                throw Exception("task1")
            }
            delay(200)
            throw Exception("task2")
        }
    }catch (e: Exception) { println("catch: ${e.message}")
    }finally { println("finally") }
//===========================================================
fun answer() {
// Exception in thread "DefaultDispatcher-worker-1" java.lang.Exception: task1
// catch: task2
// finally
// program completed successfully
}

}




suspend fun sampleB1() { //-
    try {
        coroutineScope {
            launch {
                throw Exception("task1")
            }
            writeListToFile()
            println("task2")
        }
    }catch (e: Exception) { println("catch: ${e.message}")
    }finally { println("finally") }
//======================================
fun answer() {
// task2
// catch: task1
// finally
// program completed successfully
}

}



suspend fun sampleC() { //+
    try {
        supervisorScope {
            launch {
                throw Exception("task1")
            }
            delay(100)
            throw Exception("task2")
        }
    } catch (e: Exception) { println("catch: ${e.message}") }
//===========================================================
fun answer() {
// Exception in thread "DefaultDispatcher-worker-1" java.lang.Exception: e1
// catch: e2
// program completed successfully
}

}





suspend fun sampleD() { //+
val scope = CoroutineScope(SupervisorJob() + eH)

    scope.launch {
        launch {
            throw Exception("task1")
        }
        writeListToFile()
        println("task1.1")
    }

    scope.launch {
        throw Exception("task2")
    }
//===============================================================
fun answer() {
// eHandler: task2
// task1.1
// eHandler: task1
// program completed successfully
}

}



suspend fun sampleF() { //-
    supervisorScope {
        launch {
            repeat(900000) {
                println("${++count}")
            }
        }
        throw Exception("task1")
    }
//======================================================
fun answer() {
// 900000
// Crash app
}

}
















suspend fun unknownFunction2() {

    try {
        coroutineScope {

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