package trash

import kotlinx.coroutines.*
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.CoroutineContext
import kotlin.math.abs


fun main() = runBlocking {

    repeat(100_000) {
        launch(Dispatchers.IO) {
            delay(1000L)
            println("${Thread.currentThread().name}")
        }
    }
}

//class Papa {
//    var live = "alive"
//
//    class Child {
//        var childLive = "child is alive"
//    }
//
//}























