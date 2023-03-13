package dpTwoParameters

import java.io.File

fun theMostExpensivePath() {
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

    val dp = List(n) { MutableList(m) { Triple(0, 0, 0) } }
    dp[0][0] = Triple(dpInput[0][0], 0, 0)

    for (i in 1 until dp.size) {
        dp[i][0] = Triple(dp[i - 1][0].first + dpInput[i][0], i - 1, 0)
    }
    for (i in 1 until dp[0].size) {
        dp[0][i] = Triple(dp[0][i - 1].first + dpInput[0][i], 0, i - 1)
    }

    for (i in 1 until dp.size) {
        for (j in 1 until dp[i].size) {
            dp[i][j] = if (dp[i - 1][j].first > dp[i][j - 1].first) {
                Triple(dp[i - 1][j].first + dpInput[i][j], i - 1, j)
            } else {
                Triple(dp[i][j - 1].first + dpInput[i][j], i, j - 1)
            }
        }
    }

    val route = mutableListOf<String>()

    var i = dp.lastIndex
    var j = dp[i].lastIndex

    while (i != 0 || j != 0) {
        val prevI = dp[i][j].second
        val prevJ = dp[i][j].third

        if (prevI < i) {
            route.add("D")
        }
        else if (prevJ < j) {
            route.add("R")
        }

        i = prevI
        j = prevJ
    }

    output.write("${dp.last().last().first}\n")
    output.write(route.reversed().joinToString(" "))
    output.close()
}