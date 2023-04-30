package trash.fast_function


fun main() {

    val arr = MutableList(200_000_000) { (1..100).random() }
    val arr1 = MutableList(200_000_000) { (1..100).random() }


    // удаление первого элемента хитрым способом, но порядок элементов изменится!!!
    val t2 = System.currentTimeMillis()
    repeat(30) {
        arr[0] = arr[arr.lastIndex]
        arr.removeAt(arr.lastIndex)
    }
    println(System.currentTimeMillis() - t2)



    // удаление первого элемента стандартным способом
    val t = System.currentTimeMillis()
    repeat(30) { arr1.removeAt(0) }
    println(System.currentTimeMillis() - t)
}






