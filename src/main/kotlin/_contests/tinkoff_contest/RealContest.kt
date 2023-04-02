package trash.tinkoff_contest

import java.util.Scanner

fun main() {        // 5 2 3 1    7 6 5 5    1 2 3 4

    val list = arrayListOf<Int>()

    val scn = Scanner(System.`in`)

    while (scn.hasNext()) {
        list.add(scn.nextInt())
        if (list.size > 3) break
    }

    var temp = 0
    if (list[0] <= list[1]) {
        for (i in 1.. list.lastIndex) {
            if (list[i-1] <= list[i]) {
                temp = list[i]
                if (temp == list[list.lastIndex] && i == list.lastIndex)
                    println("YES")
            }
            else {
                println("NO")
                break
            }
        }
    }

    else if (list[0] >= list[1]) {
        for (i in 1.. list.lastIndex) {
            if (list[i-1] >= list[i]) {
                temp = list[i]
                if (temp == list[list.lastIndex] && i == list.lastIndex)
                    println("YES")
            }
            else {
                println("NO")
                break
            }
        }

    }
}
