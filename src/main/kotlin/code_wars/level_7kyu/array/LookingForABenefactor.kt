package code_wars.level_7kyu.array
/*
Добавить к списку такой элемент, чтобы среднее арифметическое получилос navg
 */

fun main() {
    println(newAvg(doubleArrayOf(14.0, 30.0, 5.0, 7.0, 9.0, 11.0, 16.0), 9.0))
    println(newAvg1(doubleArrayOf(14.0, 30.0, 5.0, 7.0, 9.0, 11.0, 16.0), 90.0))
}
//----------------------------------------------------------------------------------------------------------------------
fun newAvg(a:DoubleArray, navg:Double):Long {
    val x = Math.ceil(navg * (a.size + 1) - a.sum())
    return if (x > 0) x.toLong()
    else throw IllegalArgumentException("[ERROR: x<0]")
}
//----------------------------------------------------------------------------------------------------------------------
fun newAvg1(a: DoubleArray, navg: Double) =
    Math.ceil(navg * (a.size + 1) - a.sum())
        .toLong()
        .takeIf { it > 0 }
        ?: throw IllegalArgumentException("ERROR: x<0")
//----------------------------------------------------------------------------------------------------------------------