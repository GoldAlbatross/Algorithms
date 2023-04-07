package trash

import java.util.LinkedList

fun main() {
    val arr = arrayListOf(Pair(2,9), Pair(3,8), Pair(9,4), Pair(4,8))
    val x = 9

    val ll = LinkedList<Pair<Int,Int>>()

    for (i in 0..arr.lastIndex) {
        ll.add(arr[i])
        var current = arr[0].second // set iterator -> 1st item = x
        for (j in i + 1..arr.lastIndex) {
            if (x == arr[j].first) {
                ll.add(arr[j])
                arr.remove(arr[j])
                current = arr[j].second
            }
        }
    }



}


// set(9,8,4)

// 9 = (2,9), (3,8) -> set.delete(9)

// 8 = (2,9)->(9,4)->(4,8) | (3,8) | (9,4)->(4,8) | (4,8)

// 4 = (2,9)->(9,4) | (3,8) -> set.delete(4)





