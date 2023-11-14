package trash

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.Deque
import java.util.Queue
import java.util.Stack
import java.util.Vector
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


suspend fun main() {
    println("Before")

    suspendCoroutine<Unit> { continuation ->
        thread {
            println("Suspended")
            Thread.sleep(1000)
            continuation.resume(Unit)
            println("Resumed")
        }
    }

    println("After")
}

fun sumOddLengthSubarrays(arr: IntArray): Int {
    var count = 0
    var end = 0
    val list = arr.toList()

    while(end == arr.lastIndex) {
        end += 2
        for (i in 0..arr.lastIndex) {
            count += list.subList(i,end+i).sum()
        }
    }

    return count
}

//val flow1 = flowOf("A", "B", "C")
//    .onEach { delay(400) }
//val flow2 = flowOf(1, 2, 3, 4)
//    .onEach { delay(1000) }
//
//flow1.zip(flow2) { f1, f2 -> "${f1}_${f2}" }
//.collect { println(it) }





