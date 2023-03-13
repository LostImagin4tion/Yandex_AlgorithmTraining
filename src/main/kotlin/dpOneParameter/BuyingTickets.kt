package dpOneParameter

import java.io.File

fun buyingTickets() {
    val allInput = File("input.txt").bufferedReader()
        .lineSequence()
        .iterator()

    val output = File("output.txt").bufferedWriter()

    val n = allInput.next().trim().toInt()

    val maxValue = 4000
    val peopleTime = MutableList(n + 3) { Triple(maxValue, maxValue, maxValue) }
    val dp = MutableList(n + 3) { 0 }

    for (i in 3 until n + 3) {
        val (aTime, bTime, cTime) = allInput.next()
            .trim()
            .split(" ")
            .map { it.toInt() }

        dp[i] = minOf(
            dp[i - 1] + aTime,
            minOf(
                dp[i - 2] + peopleTime[i - 1].second,
                dp[i - 3] + peopleTime[i - 2].third
            )
        )
        peopleTime[i] = Triple(aTime, bTime, cTime)
    }

    output.write(dp.last().toString())
    output.close()
}