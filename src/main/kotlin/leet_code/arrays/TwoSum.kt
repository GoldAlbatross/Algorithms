package leet_code.arrays

fun main() {
    println(twoSum1(intArrayOf(3,2,4), 6).contentToString())
}
//======================================================================================================================
fun twoSum(nums: IntArray, target: Int): IntArray {
    val list = arrayListOf<Pair<Int,Int>>()
    for (i in nums.indices) {
        list.add(i to nums[i])
    }
    list.sortBy { it.second }

    val arr = arrayListOf<Int>()
    for (i in list.indices) {
        for (j in i+1 .. list.lastIndex) {
            if (target - list[i].second == list[j].second) {
                arr.add(list[i].first)
                arr.add(list[j].first)
                return arr.toIntArray()
            }
            if (target - list[i].second < list[j].second) break
        }
    }

    return intArrayOf(-1,-1)
}
//======================================================================================================================
fun twoSum1(nums: IntArray, target: Int): IntArray {
    val map = hashMapOf<Int, Int>()
    nums.forEachIndexed { index, i ->
        val goal = target - i
        if (map[goal] != null) return intArrayOf(map[goal]!!, index)
        map[i] = index
        println(map)
    }
    return intArrayOf(-1, -1)
}
//======================================================================================================================
fun twoSum2(a: IntArray, target: Int): IntArray {
    val map = HashMap<Int,Int>()
    for (i in 0..a.lastIndex) {
        val sub = target - a[i]
        if (map.containsKey(sub)) {
            return intArrayOf(map[sub] ?: -1, i)
        }
        map[a[i]] = i
    }
    return intArrayOf(-1,-1)
}