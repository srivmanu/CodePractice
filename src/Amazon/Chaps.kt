package Amazon

import java.util.ArrayList
import java.util.Arrays
import java.util.HashMap
import java.util.HashSet
import java.util.Random

fun main() {
    val c = Chaps()
    val cs = c.makeArray(10, 1000) //{0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    val bs = c.makeArray(500000, 1000) //{5, 9, 21, 23, 26, 31, 33, 46, 65, 83, 95, 99, 104};
    Arrays.sort(cs)
    Arrays.sort(bs)
    val chs = c.makeChapters(cs)
    val bks = c.makeBookmarks(bs)
    var startTime = System.nanoTime()
    val x = c.getBookmarks2(chs, bks)
    var endTime = System.nanoTime()
    var duration = endTime - startTime
    println("binary : $duration")
    startTime = System.nanoTime()
    val y = c.getBookmarks(chs, bks)
    endTime = System.nanoTime()
    duration = endTime - startTime
    println("normal : $duration")
    c.prints(x)
    c.prints(y)
}

class Chaps {

    fun makeArray(n: Int, max: Int): IntArray {
        val arr = IntArray(n)
        val random = Random()
        for (i in 0 until n) {
            arr[i] = random.nextInt(max)
        }
        return arr
    }

    fun prints(x: HashMap<Chapter, MutableSet<Bookmark>>) {
        val keys: MutableList<Chapter> = ArrayList()
        for (key in x.keys) {
            keys.add(key)
        }
        keys.sort()
        for (i in 0 until x.size) {
            val key = keys[i]
            println("\n-------")
            println("[" + key.start + " : [ " + x[key]!!.size)
            print("] ]")
        }
    }

    fun makeBookmarks(bs: IntArray): List<Bookmark> {
        val cs = ArrayList<Bookmark>()
        for (b in bs) {
            cs.add(Bookmark(b.toLong()))
        }
        return cs
    }

    fun makeChapters(bs: IntArray): List<Chapter> {
        val cs = ArrayList<Chapter>()
        for (b in bs) {
            cs.add(Chapter(b.toLong()))
        }
        return cs
    }

    fun getBookmarks2(chaps: List<Chapter>, books: List<Bookmark>): HashMap<Chapter, MutableSet<Bookmark>> {
        val chapS: MutableList<Long> = ArrayList()
        val map = HashMap<Chapter, MutableSet<Bookmark>>()
        for (chap in chaps) {
            map[chap] = HashSet()
            chapS.add(chap.start)
        }
        for (b in books) {
            val index = binSearch(chapS, b.pos)
            map[chaps[index]]!!.add(b)
        }
        return map
    }

    private fun binSearch(arr: List<Long>, target: Long): Int {
        val n = arr.size
        if (target <= arr[0]) {
            return 0 //arr.get(0);
        }
        if (target >= arr[n - 1]) {
            return n - 1 //arr.get(n - 1);
        }
        var start = 0
        var end = n
        var mid = 0
        while (start < end) {
            mid = (start + end) / 2
            if (arr[mid] == target) {
                return mid //arr.get(mid);
            }
            if (target < arr[mid]) {
                if (mid > 0 && target > arr[mid - 1]) {
                    return mid - 1 //getClosest(arr.get(mid - 1),
                }

                end = mid
            } else {
                if (mid < n - 1 && target < arr[mid + 1]) {
                    return mid //getClosest(arr.get(mid),
                }
                start = mid + 1 // update i
            }
        }

        return mid //arr.get(mid);
    }

    fun getBookmarks(chaps: List<Chapter>, books: List<Bookmark>): HashMap<Chapter, MutableSet<Bookmark>> {
        if (chaps.isEmpty()) {
            println("Chapters empty")
        }
        if (books.isEmpty()) {
            println("Bookmarks empty")
        }
        val map = HashMap<Chapter, MutableSet<Bookmark>>()
        for (chap in chaps) {
            map[chap] = HashSet()
        }
        var countC = 1
        for (b in books) {
            var flag = 0
            for (i in countC until chaps.size) {
                if (b.pos < chaps[i].start) {
                    val l = map[chaps[i - 1]]!!
                    l.add(b)
                    map[chaps[i - 1]] = l
                    countC = i
                    flag = 1
                    break
                }
            }
            if (flag == 0) {
                val l = map[chaps[chaps.size - 1]]!!
                l.add(b)
                map[chaps[chaps.size - 1]] = l
            }
        }
        return map
    }

    inner class Bookmark(var pos: Long)
    inner class Chapter(var start: Long) : Comparable<Chapter> {

        override fun compareTo(chapter: Chapter): Int {
            return (start - chapter.start).toInt()
        }
    }
}