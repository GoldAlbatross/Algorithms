package leet_code.collections.array

fun main() {
    println(equalFrequency("abbccc"))
}

fun equalFrequency(word: String): Boolean {
    val map = hashMapOf<Char,Int>()
    var valueCount = 0
    //val arr = mutableListOf<Int>()
    val set = hashSetOf<Int>()

    for (c in word) {
        map[c] = map.getOrDefault(c, 0) + 1
    }

    for (e in map) {
        valueCount += e.value
        set.add(e.value)
    }

    if (map.size == 1) return true

    val res = map.values.fold(Pair(0,0)) { acc,it ->
        if (it != acc.first) {
            println(acc)
            Pair(it,Math.abs(acc.second - it))
        } else acc
    }


    return false

}
// [1,2,3]
// 0,0 - 2,1 - 3,1