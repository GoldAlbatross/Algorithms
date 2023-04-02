package code_wars.level_7kyu.array

fun main() {
    println(smallEnough(intArrayOf(78, 117, 110, 99, 104, 117, 107, 115), 100))
    println(smallEnough1(intArrayOf(78, 117, 110, 99, 104, 117, 107, 115), 100))
    println(smallEnough2(intArrayOf(78, 117, 110, 99, 104, 117, 107, 115), 100))
    println(smallEnough3(intArrayOf(78, 117, 110, 99, 104, 117, 107, 115), 100))
    println(smallEnough4(intArrayOf(78, 117, 110, 99, 104, 117, 107, 115), 111))
}

fun smallEnough(a : IntArray, limit : Int) : Boolean {
    val x = a.filter { it > limit }
    println(x)
    return x.isEmpty()
}

fun smallEnough1(a: IntArray, limit: Int) =
    a.all { it <= limit }

fun smallEnough2(a : IntArray, limit : Int) =
    a.none { it > limit }

fun smallEnough3(a: IntArray, limit: Int): Boolean =
    a.max() <= limit

fun smallEnough4(a : IntArray, limit : Int) : Boolean =
    a.maxOf{if (it%2 != 0) it else 0} <= limit