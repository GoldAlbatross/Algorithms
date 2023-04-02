package code_wars.level_8kyu

fun main() {
    //println(getAge("4 years old"))
    println(getAge2("55 years old"))
    //println(getAge3("6 2 old"))
    //println(getAge4("57 years old"))
    //println(getAge5("888 years old"))
    //println(getAge6("99*25"))

}

fun getAge(yearsOld: String): String =
    yearsOld.substring(0, yearsOld.indexOf("o"))

fun getAge2(yearsOld: String): String =
    yearsOld.take(1)

fun getAge3(yearsOld: String): Int =
    yearsOld[0].digitToInt()

fun getAge4(yearsOld: String): Int =
    yearsOld.first().digitToInt()

fun getAge5(yearsOld: String): Int =
    yearsOld.takeWhile { it.isDigit() }.toInt()

fun getAge6(yearsOld: String): String {
    val x = yearsOld.split("[*/-]")
    return x[1]
}
