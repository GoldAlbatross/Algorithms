package interview.equals_hashcode

class Test4(
    val id: Int,
    val name: String,
    var phone: String,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Test4

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

    //если не переопределим методы, то работает
    //если переопределили: при изменении телефона hashcode
    val a = Test4(124, "Oleg", "8-910-310-45-45")
    val list: HashMap<Test4, String> = hashMapOf()
    list.put(a, "any text")

    a.phone = "8-910-310-45-xx"

    println(list.get(a))
}