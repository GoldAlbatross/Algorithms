package leet_code.collections.array
/**
 *You are given two 0-indexed integer arrays player1 and player2, that represent the number of pins
 * that player 1 and player 2 hit in a bowling game, respectively.
 * The bowling game consists of n turns, and the number of pins in each turn is exactly 10.
 * Assume a player hit xi pins in the ith turn. The value of the ith turn for the player is:
 * 2xi if the player hit 10 pins in any of the previous two turns.
 * Otherwise, It is xi.
 * The score of the player is the sum of the values of their n turns.
 *
 * Return
 *
 * 1 if the score of player 1 is more than the score of player 2,
 * 2 if the score of player 2 is more than the score of player 1, and
 * 0 in case of a draw.
 *
 *
 * Example 1:
 * Input: player1 = [4,10,7,9], player2 = [6,5,2,3]
 * Output: 1
 * Explanation: The score of player1 is 4 + 10 + 2*7 + 2*9 = 46.
 * The score of player2 is 6 + 5 + 2 + 3 = 16.
 * Score of player1 is more than the score of player2, so, player1 is the winner, and the answer is 1.
 *
 * Example 2:
 * Input: player1 = [3,5,7,6], player2 = [8,10,10,2]
 * Output: 2
 * Explanation: The score of player1 is 3 + 5 + 7 + 6 = 21.
 * The score of player2 is 8 + 10 + 2*10 + 2*2 = 42.
 * Score of player2 is more than the score of player1, so, player2 is the winner, and the answer is 2.
 *
 * Example 3:
 * Input: player1 = [2,3], player2 = [4,1]
 * Output: 0
 * Explanation: The score of player1 is 2 + 3 = 5
 * The score of player2 is 4 + 1 = 5
 * The score of player1 equals to the score of player2, so, there is a draw, and the answer is 0.
 * */
fun main() {
    println(isWinner(intArrayOf(4,10,7,9), intArrayOf(6,5,2,3)))
}

fun isWinner(player1: IntArray, player2: IntArray): Int {
    var firstResult = 0
    var secondResult = 0
    var firstBonus = -1
    var secondBonus = -1

    for (i in 0..player1.lastIndex) {

        firstResult += player1[i] *  if (firstBonus > 0) 2 else 1
        secondResult += player2[i] * if (secondBonus > 0) 2 else 1

        if (player1[i] == 10) {
            firstBonus = 2
        } else firstBonus--

        if (player2[i] == 10) {
            secondBonus = 2
        } else secondBonus--
    }

    return when {
        firstResult > secondResult -> 1
        firstResult < secondResult -> 2
        else -> 0
    }
}