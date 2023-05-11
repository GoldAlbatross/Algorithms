package trash.singleton

class Programmer private constructor(
    private val name: String = "Petr",
    var age: Int = 38,
) {
    companion object{
        private var instance: Programmer? = null
        operator fun invoke() = synchronized(this) {
            if (instance == null)
                instance = Programmer()
            instance

        }
    }

    override fun toString(): String {
        return "Programmer(name='$name', age=$age)"
    }
}

fun main() {
    val x = Programmer()!!
    x.age = 39
    val y = Programmer()

    println(x)
    println(y)



//    val y = Programmer.instance?.age
//    println(Programmer.instance?.age)
}