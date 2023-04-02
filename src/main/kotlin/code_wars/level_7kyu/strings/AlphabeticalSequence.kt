package code_wars.level_7kyu.strings

fun main() {
    println(alphaSeq("ZpglnRxqenU"))
    println(alphaSeq1("ZpglnRxqenU"))


}

fun alphaSeq(str: String): String {
    val list = str.uppercase().toList().sorted()
    val res = arrayListOf<String>()


    for ((count, it) in list.withIndex()) {
        res.add("$it")
        val n = it -'A'
        for (i in 0..n) {
            if (i > 0) res[count] = res[count] + it.lowercase()
        }
    }
    return  res.joinToString(",")
}
//----------------------------------------------------------------------------------------------------------------------
fun alphaSeq1(str: String) =
    str.lowercase()
        .toCharArray()
        .sorted()
        .joinToString(","){ "$it".uppercase() + "$it".repeat(it -'a') }