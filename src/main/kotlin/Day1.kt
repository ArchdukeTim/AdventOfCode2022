import java.io.File
import java.util.*

fun main() {
    val input = File("src/main/resources/day1.txt").readText().trim()
    val calorieCounts = PriorityQueue<Int>(Comparator.reverseOrder())
    input.split("\n\n").forEach { group ->
        calorieCounts.add(group.split("\n").fold(0) { acc, s -> acc + s.toInt() })
    }
    println(calorieCounts.peek())
    println(calorieCounts.poll() + calorieCounts.poll() + calorieCounts.poll())
}