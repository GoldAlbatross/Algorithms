package trash


fun main() {
    println(
        findEvenNumbers(intArrayOf(2,1,3,0)).contentToString()
    )

}

fun findEvenNumbers2(digits: IntArray): IntArray {
    var num = 100
    val arr = mutableListOf<Int>()
    val mapMain = hashMapOf<Int,Int>()
    digits.forEach { mapMain[it] = mapMain.getOrDefault(it, 0) + 1 }

    while(num <= 998) {
        val map = hashMapOf<Int,Int>()
        map.putAll(mapMain)
        var flag = true

        num.toString().forEach {
            val n = it.digitToInt()
            if (map.containsKey(n)) {
                if (map[n]!! >= 1){
                    map[n] = map[n]!! - 1
                }
                else flag = false
            } else flag = false
        }
        if (flag) { arr.add(num) }
        num += 2
        flag = true
    }

    return arr.toIntArray()
}

//======================================================================================================================

fun findEvenNumbers(digits: IntArray): IntArray {
    return (100..999).filter {
            n -> n.toString().all {  //102
            d -> digits.count { it == d.digitToInt() } >=  n.toString().count { it == d }
    }
    }.filter { it % 2 == 0 }.toIntArray()
}









