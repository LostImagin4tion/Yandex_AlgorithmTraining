package dpOneParameter

import java.io.File

fun calculator() {
    val allInput = File("input.txt").bufferedReader()
        .lineSequence()
        .iterator()

    val output = File("output.txt").bufferedWriter()

    val n = allInput.next().trim().toInt()

    val dp = MutableList(n + 1) { 0 }
    val path = MutableList(n + 1) { 0 }

    for (i in 2 until dp.size) {
        val divideBy3 = if (i % 3 == 0) i / 3 else null
        val divideBy2 = if (i % 2 == 0) i / 2 else null
        val minus1 = i - 1

        dp[i] = if (divideBy3 != null && divideBy2 != null) {
            if (dp[divideBy3] <= dp[divideBy2] && dp[divideBy3] <= dp[minus1]) {
                path[i] = divideBy3
                dp[divideBy3]
            }
            else if (dp[divideBy2] <= dp[divideBy3] && dp[divideBy2] <= dp[minus1]) {
                path[i] = divideBy2
                dp[divideBy2]
            }
            else {
                path[i] = minus1
                dp[minus1]
            }
        }
        else if (divideBy3 != null) {
            if (dp[divideBy3] <= dp[minus1]) {
                path[i] = divideBy3
                dp[divideBy3]
            } else {
                path[i] = minus1
                dp[minus1]
            }
        }
        else if (divideBy2 != null) {
            if (dp[divideBy2] <= dp[minus1]) {
                path[i] = divideBy2
                dp[divideBy2]
            } else {
                path[i] = minus1
                dp[minus1]
            }
        }
        else {
            path[i] = minus1
            dp[minus1]
        }
        dp[i] += 1
    }

    var pointer = path.last()
    val ans = mutableListOf(dp.lastIndex)

    while (pointer != 0) {
        ans.add(pointer)
        pointer = path[pointer]
    }

    output.write("${dp.last()}\n${ans.reversed().joinToString(" ")}")
    output.close()
}