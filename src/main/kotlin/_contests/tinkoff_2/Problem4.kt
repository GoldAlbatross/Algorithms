package _contests.tinkoff_2

fun main() {
//    val (n, m) = readln().split(" ")
//    val str = readLine()
//    val strArr = str!!.split(" ")
//
//    val nominals = strArr.map { it.toInt() }

    val n = 2270
    val nominals = listOf(100,100, 200,200, 300,300, 450,450, 550,550, 600,600, 770,770, 900, 900)
    val start = System.currentTimeMillis()

    val allCombinations = getAllCombinations(nominals)

    allCombinations.forEach {
        val result = calculate(remainsToSteal = n.toInt(), nominals = it)
        if (result.isNotEmpty()) {
            println("${result.size}")
            println(result.joinToString(" "))
            val end = System.currentTimeMillis()
//            println("time= ${(end-start)}")
            return
        }
    }
    println(-1)

    //=======================================


//    val end = System.currentTimeMillis()
//    println((end-start))
}

fun calculate(remainsToSteal: Int, nominals: List<Int>, iteration: Int = 0): List<Int> {
    var i = 0
    var ostatok = remainsToSteal
    val iterAnswer = mutableListOf<Int>()
    while ((ostatok > 0) && (i < nominals.size)) {
        if (ostatok >= nominals[i]) {
            ostatok -= nominals[i]
            iterAnswer.add(nominals[i])
            if (ostatok == 0) {
                return iterAnswer
            }
        }
        i++
    }

    if (iteration == 0) {
        if (iterAnswer.isNotEmpty()) {
            val secondIterAnswer = calculate(ostatok, nominals, iteration = 1)
            if (secondIterAnswer.sum() == ostatok) {
                iterAnswer += secondIterAnswer
                return iterAnswer
            }
        }
    }
    return if (ostatok == 0){
        iterAnswer
    }else {
        emptyList()
    }
}


private fun  getAllCombinations(list: List<Int>): Set<List<Int>> {
    if (list.isEmpty()) return setOf(emptyList())
    val result: MutableSet<List<Int>> = mutableSetOf()
    for (i in list.indices) {
        getAllCombinations(list - list[i]).forEach {
                item -> result.add(item + list[i])
        }
    }
    return result
}