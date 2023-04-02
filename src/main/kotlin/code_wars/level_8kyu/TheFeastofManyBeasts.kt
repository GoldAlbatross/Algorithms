package code_wars.level_8kyu
/*
animals are having a feast! Each animal is bringing one dish. There is just one rule:
the dish must start and end with the same letters as the animal's name. For example,
the great blue heron is bringing garlic naan and the chickadee is bringing chocolate cake.
 */

fun main() {
    println(feast("bird", "baracud"))
    println(feast1("bird", "baracu"))
    println(feast2("bird", "baracud"))
}

fun feast(beast: String, dish: String): Boolean =
    dish[0] == beast[0] && dish[dish.lastIndex] == beast[beast.lastIndex]

fun feast1(beast: String, dish: String): Boolean =
    dish.first() == beast.first() && dish.last() == beast.last()

fun feast2(beast: String, dish: String) =
    beast.take(1) + beast.takeLast(1) == dish.take(1) + dish.takeLast(1)
