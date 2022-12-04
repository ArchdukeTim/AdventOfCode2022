import java.io.File

import Hand.*
import Result.*
import java.util.regex.Pattern


fun main() {
    // pt1
    val input = File("src/main/resources/day3.txt").readText()
    var sum = 0
    input.split('\n').forEach {
        if (it.isBlank()) return@forEach
        val h1 = it.substring(0..it.length / 2 - 1).toSet()
        val h2 = it.substring(it.length / 2).toSet()
        val common = h1.intersect(h2).elementAt(0)
        sum += if (common.isUpperCase()) {
            common - 'A' + 27
        } else {
            common - 'a' + 1
        }
    }
    println(sum)


    sum = 0
    Regex(".*\n.*\n.*\n").findAll(input).forEach{group ->
        val (a, b, c) = group.value.split('\n')
        a.toSet().intersect(b.toSet()).intersect(c.toSet()).elementAt(0).also {
            sum += if (it.isUpperCase()) {
                it - 'A' + 27
            } else {
                it - 'a' + 1
            }
        }
    }
    println(sum)
}
