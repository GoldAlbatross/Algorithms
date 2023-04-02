package code_wars.level_7kyu.strings
/*
Вступление
Идет война и никто не знает - война алфавитов!
Есть две группы враждебных писем. Напряжение между левыми и правыми буквами было слишком велико,
и началась война.

Задача
Напишите функцию, которая принимает строку боя, состоящую только из маленьких букв, и возвращает,
кто выиграл бой. Когда побеждает левая сторона, побеждает левая сторона!, когда побеждает правая сторона,
возвращается побеждает правая сторона!, в противном случае возвращается. Давайте снова сразимся!.
 */

fun main() {
    println(alphabetWar1("wpbsmqdz"))
    println(alphabetWar2("wpbsmqdz"))
    println(alphabetWar3("wpbsmqdz"))
    println(alphabetWar4("wpbsmqdz"))
    println(alphabetWar5("wpbsmqdz"))
}


fun alphabetWar1(fight: String): String {
    val forces = mapOf(
        'w' to 4, 'p' to 3, 'b' to 2, 's' to 1,
        'm' to -4, 'q' to -3, 'd' to -2, 'z' to -1)
    val result = fight.sumOf { forces.getOrDefault(it, 0) }
    return when {
        result > 0 -> "Left side wins!"
        result < 0 -> "Right side wins!"
        else -> "Let's fight again!"
    }
}

fun alphabetWar2(fight: String): String {
    val (left,right) = fight.partition { it in "wpbs" }
    left.map { when (it) {
            'w' -> 4
            'p' -> 3
            'b' -> 2
            's' -> 1
            else -> 0 }
    }
    right.map { when (it) {
        'm' -> 4
        'q' -> 3
        'd' -> 2
        'z' -> 1
        else -> 0 }
    }
    return if (left > right) "Left side wins!" else if (right> left) "Right side wins!"
           else "Let's fight again!"
}
//----------------------------------------------------------------------------------------------------------------------
const val left = "zdqm"
const val right = "sbpw"

fun String.getPowerByIndex(values: String): Int {
    return this.sumOf { values.indexOf(it) + 1 }
}

fun alphabetWar3(fight: String): String {
    val result = fight.getPowerByIndex(left) - fight.getPowerByIndex(right)
    return when {
        result == 0 -> "Let's fight again!"
        result < 0 -> "Left side wins!"
        else -> "Right side wins!"
    }
}
//----------------------------------------------------------------------------------------------------------------------
fun alphabetWar4(fight: String) = fight
        .fold(0) { a, c -> a + when (c) {
            'w' -> 4; 'p' -> 3; 'b' -> 2; 's' -> 1
            'm' -> -4; 'q' -> -3; 'd' -> -2; 'z' -> -1
            else -> 0 }
        }
        .let { if (it > 0) "Left side wins!" else if (it < 0) "Right side wins!" else "Let's fight again!" }

fun alphabetWar5(fight: String): String {

    val m: Map<Char, Int> = mapOf(
        'w' to 4, 'p' to 3, 'b' to 2, 's' to 1,
        'm' to -4, 'q' to -3, 'd' to -2, 'z' to -1)

    var balance = 0
    fight.forEach { balance += m[it] ?: 0 }

    return when {
        balance < 0 -> "Right side wins!"
        balance > 0 -> "Left side wins!"
        else -> "Let's fight again!"
    }
}