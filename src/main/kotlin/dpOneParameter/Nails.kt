package dpOneParameter

import java.io.File

fun nails() {
    val allInput = File("input.txt").bufferedReader()
        .lineSequence()
        .iterator()

    val output = File("output.txt").bufferedWriter()

    val n = allInput.next().trim().toInt()
    val nails = allInput.next()
        .trim()
        .split(" ")
        .map { it.toInt() }
        .sorted()

    val dp = MutableList(n) { 0 }

    dp[1] = nails[1] - nails[0]

    if (dp.size > 2) {
        dp[2] = nails[2] - nails[0]

        for (i in 3 until n) {
            dp[i] = minOf(dp[i - 2], dp[i - 1]) + nails[i] - nails[i - 1]
        }
    }

    output.write(dp.last().toString())
    output.close()
}