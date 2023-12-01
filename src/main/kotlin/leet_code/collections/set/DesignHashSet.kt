package leet_code.collections.set

import java.util.*
/**
 * Design a HashSet without using any built-in hash table libraries.
 *
 * Implement MyHashSet class:
 *
 * void add(key) Inserts the value key into the HashSet.
 * bool contains(key) Returns whether the value key exists in the HashSet or not.
 * void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
 *
 *
 * Example 1:
 *
 * Input
 * ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
 * [[], [1], [2], [1], [3], [2], [2], [2], [2]]
 * Output
 * [null, null, null, true, false, null, true, null, false]
 *
 * Explanation
 * MyHashSet myHashSet = new MyHashSet();
 * myHashSet.add(1);      // set = [1]
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(1); // return True
 * myHashSet.contains(3); // return False, (not found)
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(2); // return True
 * myHashSet.remove(2);   // set = [1]
 * myHashSet.contains(2); // return False, (already removed)
 * */

fun main() {

    val hash = MyHashSet()
    hash.add(1)
    hash.add(33)
    println(hash.contains(33))

}

class MyHashSet {
    private var arr = MutableList<LinkedList<Int>>(128) { LinkedList() }

    fun add(key: Int) {
        val list = arr[getBucket(key)]
        if (key !in list) list.add(key)
    }

    fun remove(key: Int) {
        val list = arr[getBucket(key)]
        if (key in list) list.remove(key)
    }

    fun contains(key: Int): Boolean {
        val list = arr[getBucket(key)]
        return key in list

    }

    private fun getBucket(key: Int): Int {
        return key % 128
    }

}























