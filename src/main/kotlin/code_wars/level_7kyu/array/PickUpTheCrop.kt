package code_wars.level_7kyu.array
/*
дано три сада, количество вешков и крышек. Собрать всё дерьмо в мешки, если вмещается (мешков * вместимость мешка(cap))
и поискать в саду собак.
 */

fun main() {
    println(crap(arrayOf(charArrayOf('_','_','_','_'), charArrayOf('_','_','_','@'), charArrayOf('_','_','@', '_')), 2, 2))
    println(crap1(arrayOf(charArrayOf('_','_','_','_'), charArrayOf('_','_','_','@'), charArrayOf('_','_','@', '_')), 2, 2))
}
//----------------------------------------------------------------------------------------------------------------------
fun crap(x: Array<CharArray>, bags: Int, cap: Int): String {
    var bagsSet: Int = bags *cap
    for (i in 0..x.lastIndex) {
        if (x[i].contains('D')) return "Dog!!"
        x[i].map { if (it == '@') bagsSet-- }
    }
    return if (bagsSet >= 0) "Clean" else "Cr@p"
}
//----------------------------------------------------------------------------------------------------------------------
fun crap1(x: Array<CharArray>, bags: Int, cap: Int): String {
    val places = x.flatMap { it.toList() }
    return when {
        places.contains('D') -> "Dog!!"
        places.count { it == '@' } > bags * cap -> "Cr@p"
        else -> "Clean"
    }
}