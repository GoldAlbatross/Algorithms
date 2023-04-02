package code_wars.level_7kyu.numbers
/*
посчитать сколько Ката нужно решить, чтобы обогнать соперника
 */

fun main() {
    println(leaderBoard("Zorro", 36_097, 20_000))
    println(leaderBoard1("Zorro", 36_097, 20_000))
}
//----------------------------------------------------------------------------------------------------------------------
fun leaderBoard(user:String, userScore:Int, yourScore:Int):String {
    val x = userScore - yourScore
    val report = "To beat $user's score, I must complete ${x / 3} Beta kata and ${x % 3} 8kyu kata."
    return when {
        x < 0 -> "Winning!"
        x == 0 -> "Only need one!"
        else -> { if (x / 3 > 1_000) "$report Dammit!" else report }
    }
}
//----------------------------------------------------------------------------------------------------------------------
fun leaderBoard1(user:String, userScore:Int, yourScore:Int) =
    with(userScore - yourScore){when {
        yourScore > userScore -> "Winning!"
        yourScore == userScore -> "Only need one!"
        this / 3 + this % 3 > 1000 -> "To beat ${user}'s score, I must complete ${this/3} Beta kata and ${this%3} 8kyu kata. Dammit!"
        else -> "To beat ${user}'s score, I must complete ${this/3} Beta kata and ${this%3} 8kyu kata." }
    }
//----------------------------------------------------------------------------------------------------------------------