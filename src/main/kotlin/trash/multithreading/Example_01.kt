package trash.multithreading


private var a = 0
private var b = 0


private var firstThread = Thread {

    a = 1
}

private var secondThread = Thread {

    b = 1
}


fun main() {
    secondThread.start()
    firstThread.start()
    println(a)
}



// 1 1
// 1 0
// 0 1
// 0 0  =>  program order переставит println(a) вверх, так как это ни на что не влияет в этом потоке!
// Дополнительно @Volatile позволяет понять компилятору, что эти переменные используются из разных потоков.