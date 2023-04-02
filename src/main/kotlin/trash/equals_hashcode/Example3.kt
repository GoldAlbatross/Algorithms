package interview.equals_hashcode

// Вывод: коллекция set не буде работать, если не переопределить 2 метода!
//============================================================================================================
class Human(
    val id: Any,
    val name: String,
    val phone: String,
) {
//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (javaClass != other?.javaClass) return false
//
//        other as Human
//
//        if (id != other.id) return false
//        if (name != other.name) return false
//        if (phone != other.phone) return false
//
//        return true
//    }
//
//    override fun hashCode(): Int {
//        var result = id.hashCode()
//        result = 31 * result + name.hashCode()
//        result = 31 * result + phone.hashCode()
//        return result
//    }
}
fun main() {

    val contact1 = Human(124, "Oleg", "8-910-310-45-45")
    val contact2 = Human(124, "Oleg", "8-910-310-45-45")
    val set = hashSetOf<Human>()

    set.add(contact1)
    set.add(contact2)

    println(set.size)
}