import java.io.File

fun main() {

    val input = File("src/main/resources/day8.txt").readLines()
    val rows = input.size
    val columns = input[0].length
    val trees = Array(rows) { Array(columns) { 0 } }


    input.forEachIndexed { index, s ->
        s.forEachIndexed { idx, c ->
            trees[index][idx] = c.digitToInt()
        }
    }

    var sum = 0
    for (i in 0 until rows) {
        for (j in 0 until columns) {
            if (i == 0 || j == 0 || i == rows - 1 || j == columns - 1) {
                sum++
                continue;
            }
            val height = trees[i][j]
            var top = true
            var bottom = true
            var left = true
            var right = true
            // visible from top
            for (k in 0 until i) {
                if (height <= trees[k][j]) {
                    top = false
                    break
                }
            }
            if (top) {
                sum++
                continue
            }
            // visible from left
            for (k in 0 until j) {
                if (height <= trees[i][k]) {
                    left = false
                    break
                }
            }
            if (left) {
                sum++
                continue
            }

            // visible from right
            for (k in (j + 1) until columns) {
                if (height <= trees[i][k]) {
                    right = false
                    break
                }
            }
            if (right) {
                sum++
                continue
            }

            // visible from right
            for (k in (i + 1) until rows) {
                if (height <= trees[k][j]) {
                    bottom = false
                    break
                }
            }
            if (bottom) {
                sum++
                continue
            }
            // visible from bottom
        }
    }
    println(sum)


    var maxScenicScore = 0
    for (row in 0 until rows) {
        for (col in 0 until columns) {
            if (row == 0 || col == 0 || row == rows - 1 || col == columns - 1) continue
            println(trees[row][col])
            val thisTree = trees[row][col]
            var scoreUp = 0
            var scoreDown = 0
            var scoreLeft = 0
            var scoreRight = 0
            for (up in row - 1 downTo 0) {
                scoreUp++
                if (trees[up][col] >= thisTree) break

            }
            for (down in row + 1 until rows) {
                scoreDown++
                if (trees[down][col] >= thisTree) break
            }
            for (left in col - 1 downTo 0) {
                scoreLeft++
                if (trees[row][left] >= thisTree) break
            }
            for (right in col + 1 until columns) {
                scoreRight++
                if (trees[row][right] >= thisTree) break
            }
            val scenicScore = scoreUp * scoreDown * scoreLeft * scoreRight
            println("$scoreUp, $scoreDown, $scoreLeft, $scoreRight")
            println(scenicScore)
            maxScenicScore = maxOf(maxScenicScore, scenicScore)
        }
    }
    println(maxScenicScore)

}