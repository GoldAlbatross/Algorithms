package trash

import java.io.PrintWriter



fun main() {
    val t = System.currentTimeMillis()


    val out = PrintWriter("input.txt")
    out.use { writer ->
        writer.println(9999)
        val x = List(9999) { (1350..1900).random() }.joinToString(" ").trim()
        writer.println(x)
        writer.println(80)
        val r = List(80) {"${(1350..1900).random()} ${(250..880).random()}\n"}.joinToString("").trim()
        writer.println(r)
    }



    print(System.currentTimeMillis() - t)
    val memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
    println("   $memory")
}





