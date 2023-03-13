package dpTwoParameters

import java.io.File

fun knightMove() {
    val allInput = File("input.txt").bufferedReader()
        .lineSequence()
        .iterator()

    val output = File("output.txt").bufferedWriter()

    val (n, m) = allInput.next()
        .trim()
        .split(" ")
        .map { it.toInt() }

    val dp = List(n) { MutableList(m) { 0 } }
    dp[0][0] = 1

    for (i in 1 until dp.size) {
        for (j in 1 until dp[i].size) {
            dp[i][j] = if (i - 2 >= 0 && j - 2 >= 0) {
                dp[i - 2][j - 1] + dp[i - 1][j - 2]
            }
            else if (i - 2 >= 0 && j - 1 >= 0) {
                dp[i -2][j - 1]
            }
            else if (i - 1 >= 0 && j - 2 >= 0) {
                dp[i - 1][j - 2]
            }
            else {
                0
            }
        }
    }


    output.write("${dp.last().last()}\n")
    output.close()
}