import java.io.File
import java.util.*

fun main() {
    val input = File("src/main/resources/day1").readLines()
    val calorieCounts = PriorityQueue<Int>(Comparator.reverseOrder())
    var currentCalories = 0
    input.forEach {
        if (it.isBlank()) {
            calorieCounts.add(currentCalories)
            currentCalories = 0
        } else {
            currentCalories += Integer.parseInt(it)
        }
    }
    println(calorieCounts.peek())
    println(calorieCounts.poll() + calorieCounts.poll() + calorieCounts.poll())
}