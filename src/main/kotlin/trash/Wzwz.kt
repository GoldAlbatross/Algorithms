package trash



import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.zip
import java.util.*

//==================================================================

fun main() {
    val test = KthLargest(3, intArrayOf(4,5,8,2))
    println(test.add(3))
    println(test.add(5))
    println(test.add(10))
    println(test.add(9))
}
class KthLargest(val k: Int, val nums: IntArray) {

    fun add(`val`: Int): Int {

        val mNums = nums + `val`
        val list = mutableListOf(Int.MIN_VALUE)

        for (num in mNums) {
            if (num >= list[list.lastIndex] && num != list[0]) {
                list.add(num)
            }
        }
        println(list)



        for (i in nums.lastIndex downTo 0) {
            nums[i] = list[i]
        }

        return list[list.size - 3]
    }

}



// []     0
// [00]   0
// [901]  0
// [09]   0

//   v    v
// [186254837]
//  012345678

// наибольшее расстояние
// наибольшая высота

//8-0 * 7 || 1
//7-1 * 8 || 3
//

//val flow1 = flowOf("A", "B", "C")
//    .onEach { delay(400) }
//val flow2 = flowOf(1, 2, 3, 4)
//    .onEach { delay(1000) }
//
//flow1.zip(flow2) { f1, f2 -> "${f1}_${f2}" }
//.collect { println(it) }



