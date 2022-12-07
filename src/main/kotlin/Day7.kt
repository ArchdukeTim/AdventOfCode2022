import java.io.File
import java.util.*

data class Directory(val name: String) {
    val directories = mutableListOf<Directory>()
    var files = 0L

    fun addDirectory(dir: String) {
        directories.add(Directory(dir))
    }

    fun addFile(f: String, s: Long) {
        files += s
    }

    fun getDirectory(name: String): Directory {
        return directories.firstOrNull { it.name == name } ?: this
    }

    val size: Long
        get() = directories.sumOf { it.size } + files


    fun totalSizeGreaterThan(total: Long): List<Directory> {
        return listOfNotNull(
            if (this.size > total) null else this,
        ) + directories.flatMap { it.totalSizeGreaterThan(total) }
    }

    fun getAllDirectories(): List<Directory> = listOf(this) + this.directories.flatMap { it.getAllDirectories() }
}

val root = Directory("/")
val directoryPath = LinkedList<Directory>()
val TOTAL_SPACE = 70000000
val NEEDED_UNUSED_SPACE = 30000000
val MAX_SIZE = TOTAL_SPACE - NEEDED_UNUSED_SPACE
fun main() {

    val input = File("src/main/resources/day7.txt").readLines()
    input.forEach {
        if (it.startsWith("$ cd ..")) {
            directoryPath.poll()
        } else if (it.startsWith("$ cd")) {
            // change directory
            changeDirectory(it.substring(5))
        } else if (it.startsWith("$ ls")) {
            Unit
        } else if (it.startsWith("dir")) {
            directoryPath.peek().addDirectory(it.substring(4))
        } else {
            val split = it.split(' ')
            directoryPath.peek().addFile(split[1], split[0].toLong())
        }
    }
    println(root.totalSizeGreaterThan(100000).sumOf { it.size })

    println(
        root.getAllDirectories().sortedBy { it.size }.reversed()
            .last { root.size - it.size < MAX_SIZE }.size
    )
}

fun changeDirectory(path: String) {
    val currentDirectory = directoryPath.peek() ?: root
    val newDirectory = currentDirectory.getDirectory(path)
    directoryPath.push(newDirectory)
}