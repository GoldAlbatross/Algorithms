package interview.equals_hashcode

// Достоинства иммутабельных объектов
// Поскольку поля никогда не меняются, то и хешкод всегда один и тот же,
// следовательно его можно вычислить один раз
//============================================================================================================
class Contact5(
    val id: Any,
    val name: String,
    val phone: String,
) {
    private val hash = 0
    init {
        hash
            .plus(id.hashCode())
            .plus(31 * hash + name.hashCode())
            .plus(31 * hash + phone.hashCode())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Contact5

        // добавил проверку, чтоб не проверять все поля
        if (hash != other.hashCode()) return false

        if (id != other.id) return false
        if (name != other.name) return false
        if (phone != other.phone) return false

        return true
    }

    override fun hashCode(): Int {
        // так как поля val то считаем хешкод только один раз
        return hash
    }

}
fun main() {

    val contact1 = Contact5(124, "Oleg", "8-910-310-45-45")
    val contact2 = Contact5(124, "Oleg", "8-910-310-45-45")
    val set = hashSetOf<Contact5>()

    set.add(contact1)
    set.add(contact2)

    println(set.size)
}