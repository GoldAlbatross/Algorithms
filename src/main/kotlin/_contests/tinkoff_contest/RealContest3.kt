package trash

import java.util.Scanner
fun main() { // aabbccddbadd

    val scn = Scanner(System.`in`)
    val length = scn.nextLine().toInt() -1
    val str = scn.nextLine().drop(1)


    if (!str.contains('a') || !str.contains('b') || !str.contains('c') || !str.contains('d')) {
        println(-1)
    } else {
        var count = 4
        var isSorted = false
        while (!isSorted) {
            isSorted = true
            for (i in 0..length - count) {
                val x = str.substring(i, i + count)
                if (x.contains('a')) {
                    if (x.contains('b')) {
                        if (x.contains('c')) {
                            if (x.contains('d')) {
                                println(count)
                                isSorted = true
                                break
                            } else isSorted = false
                        } else isSorted = false
                    } else isSorted = false
                } else isSorted = false
            }
            count++
        }
    }
}