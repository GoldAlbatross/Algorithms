package code_wars.level_7kyu.numbers

/*
увеличить количество людей в деревне до нужного количества
 */

fun main() {
    println(nbYear1(1500, 5.0, 100, 5000))
    println(nbYear2(1500, 5.0, 100, 5000))
}
//----------------------------------------------------------------------------------------------------------------------
fun nbYear1(pp0: Int, percent: Double, aug: Int, p: Int): Int {
    val percentage = percent * 0.01
    return generateSequence(pp0.toDouble()) { it * (1 + percentage) + aug }.takeWhile { it < p }.count()
}
//----------------------------------------------------------------------------------------------------------------------
fun nbYear2(pp0:Int, percent:Double, aug:Int, p:Int):Int {
    val percentage = percent * 0.01
    var years = 0
    var inhabitants = pp0
    while (inhabitants < p){
        inhabitants += (aug + inhabitants * percentage).toInt()
        years++
    }
    return years
}