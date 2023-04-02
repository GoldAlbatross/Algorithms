package code_wars.level_7kyu.strings

fun main() {
    println(fireFight("Boat Rudder Mast Boat Hull Water Fire Boat Deck Hull Fire Propeller Deck Fire Deck Boat Mast"))
}

fun fireFight(s: String): String {

 return s.split("Fire").joinToString("~~")
}
//======================================================================================================================
fun fireFight2(s: String): String {
    val regex = """(fire|Fire)""".toRegex()
    return regex.replace(s,"~~")

}
//======================================================================================================================
fun fireFight3(s: String): String {
    return s.replace("fire", "~~", true)
}