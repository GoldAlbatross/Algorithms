package _contests.yandex_contest.first


import java.io.File
import java.io.PrintWriter
import java.util.Scanner


fun main() {
    val t = System.currentTimeMillis()

    val input = "input.txt"
    val output = "output.txt"
    val scn = Scanner(File(input))
    val out = PrintWriter(output)

    val l1 = scn.nextInt()
    val line1 = MutableList(l1) {scn.nextInt()}
    val l2 = scn.nextInt()
    val line2 = MutableList(l2) {scn.nextInt()}
    val l3 = scn.nextInt()
    val line3 = MutableList(l3) {scn.nextInt()}


    val arr = ArrayList<Pair<Int,ArrayList<Int>>>()
    //arr.add(compare(line1, line2, line3))
    println("$line1 \n$line3 \n$line2\n")
    arr.add(compare(line1, line3, line2))
    println("29 -> $arr")















    //println(System.currentTimeMillis() - t)
    val memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
    //println(memory / 1024)

}

fun compare(list1: MutableList<Int>, list2: MutableList<Int>, list3: MutableList<Int>): Pair<Int,ArrayList<Int>> {
    val arr = mutableListOf<Int>()
    for (i in 0..list1.lastIndex) {
        for (j in 0..list2.lastIndex) {
            if (list1[i] == list2[j]) {

                if (i < j) {
                    arr.addAll(list2.take(j) + list1.drop(i))
                    println("59 $i|$j -> $arr")
                }
                if(i > j) {
                    arr.addAll(arr.take(i+1) + list2.drop(j+1))
                    println("63 $i|$j -> $arr")
                }
                break
            }
        }
        if (arr.isNotEmpty()) break
    }

    val temp = ArrayList<Int>()
    for (i in 0..arr.lastIndex) {
        for (j in 0..list3.lastIndex) {
            if (arr[i] == list3[j]) {

                if (i < j) {
                    arr.addAll(list3.take(j) + arr.drop(i))
                    println("81 $i|$j -> $arr")
                }
                if(i > j) {
                    arr.dropLast(arr.size - j+1)
                    arr.addAll(list3.drop(j+1))
                    println("85 $i|$j -> $arr")
                }
                break
            }
        }
    }
    return Pair(temp.size, temp)
}



