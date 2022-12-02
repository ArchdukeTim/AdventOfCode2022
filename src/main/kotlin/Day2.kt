import java.io.File

import Hand.*
import Result.*

enum class Hand(val score: Int) {
    ROCK(1), // 3 + 1 mod 3 + 1
    PAPER(2), // 1
    SCISSORS(3) // 2


}

enum class Result(val score: Int) {
    WIN(6),
    LOSE(0),
    DRAW(3)
}

fun main() {
    // pt1
    val input = File("src/main/resources/day2.txt").readText().trim()
    var score = 0
    input.split('\n').forEach { round ->
        val (op, me) = round.split(' ')
        val opHand = when (op) {
            "A" -> ROCK
            "B" -> PAPER
            else -> SCISSORS
        }

        val myHand = when (me) {
            "X" -> ROCK
            "Y" -> PAPER
            else -> SCISSORS
        }


        score += myHand.score + when ((myHand.score - opHand.score).mod(3)) {
            0 -> 3
            1 -> 6
            else -> 0
        }

    }
    println(score)
    // pt2
    score = 0
    input.split('\n').forEach { round ->
        val (op, me) = round.split(' ')
        val opHand = when (op) {
            "A" -> ROCK
            "B" -> PAPER
            else -> SCISSORS
        }

        val myHand = when (me) {
            "X" -> LOSE
            "Y" -> DRAW
            else -> WIN
        }


        score += myHand.score + when (myHand) {
            DRAW -> opHand.score
            WIN -> opHand.score % 3 + 1
            LOSE -> (opHand.score + 1) % 3 + 1
        }
    }
    println(score)
}
