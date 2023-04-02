package code_wars.level_7kyu.numbers

/*
проверить решение по Тюрингу(перевернуть все числа)
 */
fun main(){
    println(isTuringEquation("73+42=16"))
    println(isTuringEquation1("73+42=16"))
}
//----------------------------------------------------------------------------------------------------------------------
fun isTuringEquation(s: String): Boolean {
    val list = s.split(Regex("[+=]")).map { it.reversed().toInt() }
    return list[0] + list[1] == list[2]
}
//----------------------------------------------------------------------------------------------------------------------
fun isTuringEquation1(s: String): Boolean = s
    .split('+', '=')
    .map { it.reversed().toInt() }
    .let { it[0] + it[1] == it[2] }
//----------------------------------------------------------------------------------------------------------------------