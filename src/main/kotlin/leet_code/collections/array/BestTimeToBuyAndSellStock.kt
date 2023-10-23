package leet_code.collections.array

// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day
// in the future to sell that stock.
//Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
fun main() {
    println(maxProfit(intArrayOf(5,8,3,4,2,7,9)))
}

fun maxProfit(prices: IntArray): Int {
    var profit = 0
    var buy = 0
    var sell = 1

    while(sell < prices.size) {
        if(prices[buy] > prices[sell]) {
            buy++
            sell = buy + 1
        } else {
            profit = maxOf(profit, prices[sell] - prices[buy])
            sell++
        }
    }
    return profit
}