import java.io.File

fun main() {
    // pt1
    val input = File("src/main/resources/day3.txt").readLines()
    var sum = 0
    val chars = ('a'..'z').toList() + ('A'..'Z').toList()
    for (line in input) {
        val h1 = line.substring(0, line.length / 2).toSet()
        val h2 = line.substring(line.length / 2).toSet()
        val common = h1.intersect(h2).elementAt(0)
        sum += chars.indexOf(common) + 1

    }
    println(sum)


    println(
        input.chunked(3).sumOf {chunk ->
            chars.indexOf(chunk[0].toSet().intersect(chunk[1].toSet()).intersect(chunk[2].toSet()).elementAt(0)) + 1
        }
    )
}
