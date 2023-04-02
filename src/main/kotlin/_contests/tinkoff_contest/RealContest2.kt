package trash

import java.util.*
import kotlin.math.ceil

fun main() {        // 3 2 2 - 3      7 3 2  - 5


    val scn = Scanner(System.`in`)

    val june = scn.nextInt().toDouble()
    val sen = scn.nextInt().toDouble()
    val count = scn.nextInt().toDouble()

    var x = 0.0
    var speed = sen / count
    x = june / speed

    println(ceil(x).toInt())



}