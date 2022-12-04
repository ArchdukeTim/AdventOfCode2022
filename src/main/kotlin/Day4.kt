import java.io.File

fun main() {
    // pt1
    val input = File("src/main/resources/day4.txt").readText()
    println(input.split('\n').count {
        val (one, two) = it.split(',')
        val (oneS, oneE) = one.split('-')
        val (twoS, twoE) = two.split('-')
        val range1 = IntRange(oneS.toInt(), oneE.toInt())
        val range2 = IntRange(twoS.toInt(), twoE.toInt())
        // pt 1
        (range1.first in range2 && range1.last in range2 || range2.first in range1 && range2.last in range1)
        // pt 2
//        (range1.first in range2 || range1.last in range2 || range2.first in range1 || range2.last in range1)
    })
}
