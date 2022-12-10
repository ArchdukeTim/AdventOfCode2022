import java.io.File

data class C(var x: Int, var y: Int)

fun main() {
    val input = File("src/main/resources/day9e.txt").readLines()
    val head = C(0, 0)
    val tail = C(0, 0)

    for (line in input) {
        val dir = line[0]
        val dist = Integer.parseInt(line.substring(2))

        var lastDir = ' '
        when (dir) {
            'R' -> {
                head.x += dist
            }

            'U' -> {
                head.y += dist
            }

            'D' -> {
                head.y -= dist
            }

            'L' -> {
                head.x -= dist
            }
        }
        lastDir = dir
    }

    println(head)
}