package dpOneParameter

import java.io.File

fun grasshopper() {
    val allInput = File("input.txt").bufferedReader()
        .lineSequence()
        .iterator()

    val output = File("output.txt").bufferedWriter()

    val (n, k) = allInput.next()
        .trim()
        .split(" ")
        .map { it.toInt() }

    val dp = MutableList(n) { 0 }
    dp[0] = 1

    for (i in dp.indices) {
        var j = 1

        while (i - j >= 0 && j <= k) {
            dp[i] += dp[i - j]
            j++
        }
    }

    output.write(dp.last().toString())
    output.close()
}