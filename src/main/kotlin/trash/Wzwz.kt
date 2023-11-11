package trash



import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.zip
import java.util.*

//==================================================================

fun main() {
    duplicateZeros(intArrayOf(0,1,2,0,3,3))
}

fun duplicateZeros(arr: IntArray): Unit {
    val stack = Stack<Int>()
    var i = 0
    println("arr:   ${arr.contentToString()}\n")

    while (stack.size < arr.size) {
        if (arr[i] == 0) {
            stack.push(0)
        }
        stack.push(arr[i++])
    }
    println("stack: $stack")

    for (i in arr.lastIndex downTo 0) {
        arr[i] = stack.pop()
    }
    println("arr:   ${arr.contentToString()}\n")

// v
//[10230450]

}


//[]
//[0001]

//v
//[00230450]


//1023
//составить стэк и туда записать все что не 0 = 54321




//val flow1 = flowOf("A", "B", "C")
//    .onEach { delay(400) }
//val flow2 = flowOf(1, 2, 3, 4)
//    .onEach { delay(1000) }
//
//flow1.zip(flow2) { f1, f2 -> "${f1}_${f2}" }
//.collect { println(it) }



