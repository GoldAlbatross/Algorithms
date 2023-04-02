package interview.equals_hashcode

//Без переопределения equals()/hashCode() два объекта с совершенно одинаковыми полями не дадут true
//=============================================================================================================
class Contact(
    val id: Int,
    val name: String,
    val phone: String,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Contact

        if (id != other.id) return false
        if (name != other.name) return false
        if (phone != other.phone) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        result = 31 * result + phone.hashCode()
        return result
    }
}
fun main() {
    val contact1 = Contact(124, "Oleg", "8-910-310-45-45")
    val contact2 = Contact(124, "Oleg", "8-910-310-45-45")

    println(contact1.hashCode())
    println(contact2.hashCode())

    println(contact1 == contact2)
}

