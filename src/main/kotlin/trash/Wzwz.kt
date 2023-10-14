package trash

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Job
import kotlinx.coroutines.async


fun main() {

    val x: Deferred<Int?> = CoroutineScope(Job()).async {
        return@async null
    }

    println(x.onAwait)

}







