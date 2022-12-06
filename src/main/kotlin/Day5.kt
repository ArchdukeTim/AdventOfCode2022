import java.io.File
import java.util.*

val stacks: List<Deque<Char>> = listOf(
   LinkedList(listOf('f', 'h', 'm', 't', 'v', 'l', 'd')),
    LinkedList(listOf('p', 'n', 't', 'c', 'j', 'g', 'q', 'h')),
    LinkedList(listOf('h', 'p', 'm', 'd', 's', 'r')),
    LinkedList(listOf('f', 'v', 'b', 'l')),
    LinkedList(listOf('q', 'l', 'g', 'h', 'n')),
    LinkedList(listOf('p', 'm', 'r', 'g', 'd', 'b', 'w', )),
    LinkedList(listOf('q','l', 'h', 'c', 'r', 'n', 'm', 'g', )),
    LinkedList(listOf('w', 'l', 'c')),
    LinkedList(listOf('t', 'm', 'z', 'j', 'q', 'l', 'd', 'r')),
)
fun main() {
    // pt1
    val input = File("src/main/resources/day5.txt").readLines()

    for (line in input) {
        val parse = line.split(' ')
        println(stacks)
        val count = parse[1].toInt()
        val from = parse[3].toInt() - 1
        val to = parse[5].toInt() - 1

        val removed = LinkedList<Char>()
        for (i in 0 until count) {
            removed.push(stacks[from].pop())
        }
        while(removed.isNotEmpty()) {
            stacks[to].push(removed.pop())
        }
    }
    stacks.forEach {
        print(it.pop())
    }
}
