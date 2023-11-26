package trash

import java.util.*


fun main()  {


val x = MyStack()

    println(x.push(1))
    println(x.push(2))
    println(x.top())
    println(x.pop())
    println(x.empty())

}

class MyStack() {
    var arr = mutableListOf<Int>()

    fun push(x: Int) {
        arr.add(x)
    }

    fun pop(): Int {

        return arr.removeAt(arr.lastIndex)
    }

    fun top(): Int {
        return  if (arr.lastIndex == -1) -1
        else arr[arr.lastIndex]
    }

    fun empty(): Boolean {
        return arr.isEmpty()
    }

}







