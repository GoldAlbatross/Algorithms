package trash

import java.util.Collections

fun main() {
    println(permutations(listOf("A", "B", "C")))
}


fun permutations(input: List<String>): List<List<String>> {
    val solutions = mutableListOf<List<String>>()
    permutationsRecursive(input, 0, solutions)
    return solutions
}


fun permutationsRecursive(input: List<String>, index: Int, answers: MutableList<List<String>>) {
    if (index == input.lastIndex) answers.add(input.toList())
    for (i in index .. input.lastIndex) {
        Collections.swap(input, index, i)
        permutationsRecursive(input, index + 1, answers)
        Collections.swap(input, i, index)
    }
}