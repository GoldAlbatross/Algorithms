package trash.multithreading


// задача: вывести в консоль 1 1

// while() используется, так как поток может самопроизвольно просыпаться
private var a = 0
private var b = 0
private val lock = Object()


private var firstThread = Thread {

    a = 1
    synchronized(lock) {
        while (b == 0) {
            lock.wait()
        }
        lock.notifyAll()
        println("b: $b")
    }
}

private var secondThread = Thread {

    b = 1
    synchronized(lock) {
        while (a == 0) {
            lock.wait()
        }
        lock.notifyAll()
        println("a: $a")
    }
}

fun main() {
    firstThread.start()
    secondThread.start()
}

