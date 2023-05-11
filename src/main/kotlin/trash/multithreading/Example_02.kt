package trash.multithreading

import java.util.concurrent.locks.ReentrantReadWriteLock

// Задача: вывести результат только одного потока

// @Volatile гарантирует синхранизацию атомарной операции( чтение или запись)
// инкремен не является атомарной операцией
// Дополнительно @Volatile позволяет понять компилятору, что эта переменная используются из разных потоков.
// Если не использовать join(), то компилятор может переставить println(a) на 22 строчку(Program order)
@Volatile
private var a = 0
private var aThread = Thread{
    repeat(10000) {
        a = 1
    }
}

private var bThread = Thread{
    repeat(10000) {
        a = 5
    }
}

fun main() {

    aThread.start()
    bThread.start()
    aThread.join()
    bThread.join()

    println(a)

}