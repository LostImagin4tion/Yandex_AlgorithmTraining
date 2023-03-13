package dpTwoParameters

import java.io.File

fun greatestCommonSubsequence() {
    val allInput = File("input.txt").bufferedReader()
        .lineSequence()
        .iterator()

    val output = File("output.txt").bufferedWriter()

    val n1 = allInput.next().trim().toInt()
    val sequence1 = allInput.next()
        .trim()
        .split(" ")
        .map { it.toInt() }

    val n2 = allInput.next().trim().toInt()
    val sequence2 = allInput.next()
        .trim()
        .split(" ")
        .map { it.toInt() }

    val dp = List(n1 + 1) { MutableList(n2 + 1) { 0L } }

    for (i in 1 until n1 + 1) {
        for (j in 1 until n2 + 1) {
            dp[i][j] = if (sequence1[i - 1] == sequence2[j - 1]) {
                1 + dp[i - 1][j - 1]
            } else {
                maxOf(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }

    if (dp.last().last() == 0L) {
        return
    }

    val route = mutableListOf<Int>()

    var i = n1
    var j = n2

    while (i != 0 && j != 0) {
        if (sequence1[i - 1] == sequence2[j - 1]) {
            route.add(sequence1[i - 1])
            i--
            j--
        }
        else if (dp[i][j] == dp[i - 1][j]) {
            i--
        }
        else {
            j--
        }
    }

    output.write(route.reversed().joinToString(" "))
    output.close()
}