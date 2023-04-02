package code_wars.level_7kyu.array

/*
проверить содержит ли массив все возможные комбинации букв заданного слова.
 */

fun main() {
    containAllRots("bsjq", arrayListOf("bsjq", "qbsj", "sjqb", "twZNsslC", "jqbs"))
}
//----------------------------------------------------------------------------------------------------------------------
fun containAllRots(strng:String, arr:ArrayList<String>):Boolean {
    return arr.containsAll(List(strng.length) { (strng.drop(it) + strng.take(it)) })
}

