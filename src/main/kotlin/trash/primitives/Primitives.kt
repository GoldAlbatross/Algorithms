package trash.primitives

fun main() {
    val x: Int = (0..7).random()
    if (x is Int)
        println("yes")
    else println("no")
}