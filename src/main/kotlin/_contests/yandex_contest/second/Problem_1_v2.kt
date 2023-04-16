package _contests.yandex_contest.second


fun main() {
    val input = "input.txt"
    val output = "output.txt"
    val scanner = java.util.Scanner(java.io.File(input))
    val writer = java.io.PrintWriter(output)


    val a = scanner.next().toBigInteger()
    val b = scanner.next().toBigInteger()
    val c = scanner.next().toBigInteger()


    val result = when {
        (a > b && a < c) -> a
        (b > a && b < c) -> b
        (c > a && c < b) -> c
        (a < b && a > c) -> a
        (b < a && b > c) -> b
        (c < a && c > b) -> c
        (a == b || a == c) -> a
        (b == c) -> b
        else -> (-1).toBigInteger()
    }


    writer.use { it.print(result.toString()) }
}
