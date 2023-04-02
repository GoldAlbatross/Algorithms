package code_wars.level_7kyu.lists
/*
There is a bus moving in the city which takes and drops some people at each bus stop.
You are provided with a list (or array) of integer pairs.
Elements of each pair represent the number of people that get on the bus (the first item) and
the number of people that get off the bus (the second item) at a bus stop.

Your task is to return the number of people who are still on the bus after the last bus stop (after the last array).
Even though it is the last bus stop, the bus might not be empty and some people might still be inside the bus,
they are probably sleeping there :D
 */

fun main() {
    println(people(arrayOf(3 to 0, 9 to 1, 4 to 10, 12 to 2, 6 to 1, 7 to 10)))
    println(people1(arrayOf(3 to 0, 9 to 1, 4 to 10, 12 to 2, 6 to 1, 7 to 10)))
}
//----------------------------------------------------------------------------------------------------------------------
fun people(busStops: Array<Pair<Int, Int>>) : Int =
    busStops.sumOf { it.first - it.second }
//----------------------------------------------------------------------------------------------------------------------
fun people1(busStops: Array<Pair<Int, Int>>) : Int =
    with(busStops.unzip()) { first.sum() - second.sum() }
//----------------------------------------------------------------------------------------------------------------------

