package trash



import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.zip

//==================================================================

suspend fun main() {
val data = if ((0..1).random() == 1) "data" else "boss"

    val a = buildString {                 // yes
        append("data")
        insert(0,"yes")
        setLength(length - "data".length)
    }

    val b = "data".substring(1, 4)                      // ata

    val c = "data".removeRange(1, 4)                      // d

    val d = ""




    println(a)
    println(b)
    println(c)
    println(d)
    println(data)

} // (1 sec)  A_1  (1 sec)  B_2  (1 sec)  C_3



//fun main(args: Array<String>) {
//    val numbers = arrayOf(10, 15, 25, 30)
//    val objects: Array<Any> = numbers //1
//    println(objects[2]) //2
//    objects[2] = "meow!" //3
//}





//val flow1 = flowOf("A", "B", "C")
//    .onEach { delay(400) }
//val flow2 = flowOf(1, 2, 3, 4)
//    .onEach { delay(1000) }
//
//flow1.zip(flow2) { f1, f2 -> "${f1}_${f2}" }
//.collect { println(it) }



