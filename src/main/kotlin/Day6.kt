import java.io.File

fun main() {
    val input = File("src/main/resources/day6.txt").readText().toList()

    // pt 1
    //val windows = input.windowed(4, 1)
    // pt 2
    val windows = input.windowed(14, 1)

    windows.forEachIndexed { index, chars ->
        for (char in chars) {
            if (chars.count() { it == char } > 1) {
                return@forEachIndexed
            }
        }
        println(index+chars.size)
        return
    }


}
