package leet_code.collections.set

fun main() {
    println(isPathCrossing("NES"))
}

fun isPathCrossing(path: String): Boolean {
    var nCount = 0
    var eCount = 0
    val set = hashSetOf(Pair(0,0))

    for (c in path) {
        when (c) {
            'N' -> ++nCount
            'S' -> --nCount
            'E' -> ++eCount
            'W' -> --eCount
        }

        val pair = Pair(nCount,eCount)
        if (pair in set) return true
        set.add(pair)
    }

    return false
}