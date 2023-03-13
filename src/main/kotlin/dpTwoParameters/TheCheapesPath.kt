package dpTwoParameters

import java.io.File

fun theCheapestPath() {
    val allInput = File("input.txt").bufferedReader()
        .lineSequence()
        .iterator()

    val output = File("output.txt").bufferedWriter()

    val (n, m) = allInput.next()
        .trim()
        .split(" ")
        .map { it.toInt() }

    val dpInput = List(n) {
        allInput.next()
            .trim()
            .split(" ")
            .map { it.toInt() }
    }

    val dp = List(n) { MutableList(m) { Int.MAX_VALUE } }
    dp[0][0] = dpInput[0][0]

    for (i in 1 until dp.size) {
        dp[i][0] = dp[i - 1][0] + dpInput[i][0]
    }
    for (i in 1 until dp[0].size) {
        dp[0][i] = dp[0][i - 1] + dpInput[0][i]
    }

    for (i in 1 until dp.size) {
        for (j in 1 until dp[i].size) {
            dp[i][j] = minOf(dp[i - 1][j], dp[i][j - 1]) + dpInput[i][j]
        }
    }

    output.write("${dp.last().last()}")
    output.close()
}