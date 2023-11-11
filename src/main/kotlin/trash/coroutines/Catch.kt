package trash.coroutines

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    flow {
        repeat(5) {
            if (it == 3) throw AssertionError()
            emit("Значение $it")
        }
    }.catch { e ->
        println("Ошибочка вышла: $e")
    }.collect { it ->
        println(it)
    }
}