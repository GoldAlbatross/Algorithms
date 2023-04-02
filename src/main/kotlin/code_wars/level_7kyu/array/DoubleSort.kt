package code_wars.level_7kyu.array
/*
Simple enough this one - you will be given an array. The values in the array will either be numbers or strings,
or a mix of both. You will not get an empty array, nor a sparse one.

Your job is to return a single array that has first the numbers sorted in ascending order,
followed by the strings sorted in alphabetic order. The values must maintain their original type.

Note that numbers written as strings are strings and must be sorted with the other strings.
*/

fun main(){
    val a: Array<Any> = arrayOf(1, 3, "ert", "sss", "3.4ff", 3.7, 3.5)
    DoubleSort.dbSort(a)
}


object DoubleSort {
    fun dbSort(a: Array<Any>): Array<Any> {
        val x = (a.filterIsInstance<Number>().sortedBy { it.toDouble() } +
                 a.filterIsInstance<String>().sorted()).toTypedArray()
        println(x.contentToString())
        return a
    }
}