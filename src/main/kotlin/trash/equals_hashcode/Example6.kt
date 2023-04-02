package interview.equals_hashcode


// Вывод: коллекция map не позволит получить значение по измененному ключу так как изменился хешкод,
// но и по старому ключу, так как метод equals() теперь видит, что ключи разные.
// Вывод: делать переменные val
//============================================================================================================
class Contact6(
    var id: Any,
    var name: String,
    var phone: String,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Contact6

        if (id != other.id) return false
        if (name != other.name) return false
        if (phone != other.phone) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + phone.hashCode()
        return result
    }

    override fun toString(): String {
        return "Contact6(id=$id, name='$name', phone='$phone')"
    }

}
fun main() {

    val contact1 = Contact6(124, "Oleg", "8-910-310-45-45")
    val contact2 = Contact6(124, "Oleg", "8-910-310-45-45")
    val map = hashMapOf<Contact6, String>()


    map.put(contact1, "Moscow")

    contact1.phone = "8-000-000-00-00"

    println(map[contact1])

}
