package trash



import kotlinx.coroutines.*

fun main() = runBlocking {
    launch {
        println("Задача 1")
        cancel()
        println("Задача 2")
        delay(400)
        println("Задача 3")
    }

    val def = async(Dispatchers.Default) {
        println("Задача 4")
        println("Задача 5")
        delay(200)
        println("Задача 6")
        500
    }.await()

    println("Задача завершена $def")
}

