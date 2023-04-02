fun main() {
    maxRot(507992495L)
}

fun maxRot(n:Long):Long {
    val s: MutableList<Char> = n.toString().toMutableList()
    var x = 507992495L

    for (i in 0 until s.size-1) {
        s.add(s[i])
        s.removeAt(i)
        x = maxOf(x, x(s))
    }
    return x
}

fun x(s: MutableList<Char>): Long {
    var a = StringBuilder("")
    s.map { a.append(it) }
    return a.toString().toLong()
}




