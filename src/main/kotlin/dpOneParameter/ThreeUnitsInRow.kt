package dpOneParameter

import java.io.File

fun threeUnitsInRow() {
    val allInput = File("input.txt").bufferedReader()
        .lineSequence()
        .iterator()

    val output = File("output.txt").bufferedWriter()

    val n = allInput.next().trim().toInt()

    val dp = MutableList(n) { 0 }
    dp[0] = 2

    if (n > 1) {
        dp[1] = 4

        if (n > 2) {
            dp[2] = 7

            if (n > 3) {
                for (i in 3 until n) {
                    dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
                }
            }
        }
    }

    output.write(dp.last().toString())
    output.close()
}