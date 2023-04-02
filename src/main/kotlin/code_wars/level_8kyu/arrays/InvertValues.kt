package code_wars.level_8kyu.arrays

fun main(){
println(invert(intArrayOf(1,2,3,4,5)).contentToString())
println(invert1(intArrayOf(1,2,3,4,5)).contentToString())
println(invert2(intArrayOf(1,2,3,4,5)).contentToString())
println(invert3(intArrayOf(1,2,3,4,5)).contentToString())
println(invert4(intArrayOf(1,2,3,4,5)).contentToString())
}

fun invert(arr: IntArray): IntArray {
    val x= IntArray(arr.size)
    for (i in 0..arr.lastIndex) {
        x[i] = -1 * arr[i]
    }
    return x
}

fun invert1(arr: IntArray) =
    arr.map { -it }.toIntArray()

fun invert4(arr: IntArray): IntArray =
    arr.map { x -> -x }.toIntArray()

fun invert2(arr: IntArray): IntArray {
    return IntArray(arr.size){ -arr[it] }
}

fun invert3(arr: IntArray): IntArray {
    for (i in arr.indices)
        arr[i]*=-1
    return arr
}
