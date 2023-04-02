package code_wars.level_8kyu.arrays

// Формула суммы арифметической прогрессии Sn = ((a1 + an) * n) / 2
// Sn -сумма
// n -количество элементов?
// a1 -первый элемент
// an -энный элемент

fun main() {
    println(findNum(arrayOf(0,1,2,6,5,4)))
}

fun findNum(arr: Array<Int>): Int {
    val n = arr.size
    return ((1 + n) * n / 2) - arr.sum()
}