package _contests.tinkoff_2

data class Road(val from: Int, val to: Int, val length: Int)

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val roads = mutableListOf<Road>()

    repeat(m) {
        val (v, u, w) = readln().split(" ").map { it.toInt() }
        roads.add(Road(v, u, w))
    }

    val maxRoadLength = roads.maxOf { it.length }

    fun countStates(roadLength: Int): Int {
        val states = mutableSetOf<Int>()
        roads.forEach { road ->
            if (road.length > roadLength) {
                states.add(road.from)
                states.add(road.to)
            }
        }
        return states.size
    }

    var left = 0
    var right = maxRoadLength
    var result = 0

    while (left <= right) {
        val mid = (left + right) / 2
        if (countStates(mid) >= n) {
            result = mid
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    println(result)
}