package interview.equals_hashcode

// Вывод: коллекции в java используют под капотом equals,
// мы можем менять логику работы коллекций изменяя этот метод.
//============================================================================================================
class Man(
    val id: Int,
    val name: String,
    val phone: String,
) {
//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (javaClass != other?.javaClass) return false
//
//        other as Man
//
//        if (id != other.id) return false
//        if (name != other.name) return false
//        if (phone != other.phone) return false
//
//        return true
//    }
//
//    override fun hashCode(): Int {
//        var result = id
//        result = 31 * result + name.hashCode()
//        result = 31 * result + phone.hashCode()
//        return result
//    }
}
fun main() {

    val contact1 = Man(124, "Oleg", "8-910-310-45-45")
    val contact2 = Man(124, "Oleg", "8-910-310-45-45")

    val list = mutableListOf<Man>()
    list.add(contact1)

    println(list.contains(contact2))
    println(list.indexOf(contact2))
    list.remove(contact2)

    println(list.size)
}