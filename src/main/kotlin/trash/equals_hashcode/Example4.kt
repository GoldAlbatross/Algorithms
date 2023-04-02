package interview.equals_hashcode

// Вывод: в коллекции set нужно изменить проверку только по id,
// тогда можно вносить изменения в существующие контакты, не земеняя их.
//============================================================================================================
class Contact4(
    val id: Any,
    val name: String,
    val phone: String,
) {

    override fun toString(): String {
        return "\nContact4(id=$id, name='$name', phone='$phone')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Contact4

        if (id != other.id) return false
        // вот тут убрали проверку остальных полей

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
        // вот тут убрали расчет хеша по другим полям
    }
}
fun main() {

    val set = hashSetOf<Contact4>()

    val contact1 = Contact4(124, "Oleg", "8-910-310-45-45")
    set.add(contact1)

    val contact2 = Contact4(124, "Oleg", "8-000-000-00-00")
    set.remove(contact2)
    set.add(contact2)

    println(set.toString())
}