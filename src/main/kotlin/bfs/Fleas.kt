package bfs

import java.io.File

fun fleas() {
    val allInput = File("input.txt").bufferedReader()
        .lineSequence()
        .iterator()

    val output = File("output.txt").bufferedWriter()

    val (n, m, targetX, targetY, q) = allInput.next()
        .trim()
        .split(" ")
        .map { it.toInt() }

    val fleas = MutableList(q) {
        allInput.next()
            .split(" ")
            .map {
                it.toInt()
            }
            .let {
                Pair(it[0], it[1])
            }
    }

    val visited = List(n + 1) { MutableList(m + 1) { -1 } }
    val queue = mutableListOf<Triple<Int, Int, Int>>()

    queue.add(Triple(targetX, targetY, -1))

    while (queue.isNotEmpty()) {
        val current = queue.removeFirst()

        if (visited[current.first][current.second] == -1) {
            visited[current.first][current.second] = current.third + 1

            if (current.first + 2 < n + 1 && current.second + 1 < m + 1) {
                if (visited[current.first + 2][current.second + 1] == -1) {
                    queue.add(
                        Triple(
                            current.first + 2,
                            current.second + 1,
                            current.third + 1
                        )
                    )
                }
            }
            if (current.first + 1 < n + 1 && current.second + 2 < m + 1) {
                if (visited[current.first + 1][current.second + 2] == -1) {
                    queue.add(
                        Triple(
                            current.first + 1,
                            current.second + 2,
                            current.third + 1
                        )
                    )
                }
            }
            if (current.first - 1 >= 1 && current.second + 2 < m + 1) {
                if (visited[current.first - 1][current.second + 2] == -1) {
                    queue.add(
                        Triple(
                            current.first - 1,
                            current.second + 2,
                            current.third + 1
                        )
                    )
                }
            }
            if (current.first - 2 >= 1 && current.second + 1 < m + 1) {
                if (visited[current.first - 2][current.second + 1] == -1) {
                    queue.add(
                        Triple(
                            current.first - 2,
                            current.second + 1,
                            current.third + 1
                        )
                    )
                }
            }
            if (current.first - 1 >= 1 && current.second - 2 >= 1) {
                if (visited[current.first - 1][current.second - 2] == -1) {
                    queue.add(
                        Triple(
                            current.first - 1,
                            current.second - 2,
                            current.third + 1
                        )
                    )
                }
            }
            if (current.first - 2 >= 1 && current.second - 1 >= 1) {
                if (visited[current.first - 2][current.second - 1] == -1) {
                    queue.add(
                        Triple(
                            current.first - 2,
                            current.second - 1,
                            current.third + 1
                        )
                    )
                }
            }
            if (current.first + 1 < n + 1 && current.second - 2 >= 1) {
                if (visited[current.first + 1][current.second - 2] == -1) {
                    queue.add(
                        Triple(
                            current.first + 1,
                            current.second - 2,
                            current.third + 1
                        )
                    )
                }
            }
            if (current.first + 2 < n + 1 && current.second - 1 >= 1) {
                if (visited[current.first + 2][current.second - 1] == -1) {
                    queue.add(
                        Triple(
                            current.first + 2,
                            current.second - 1,
                            current.third + 1
                        )
                    )
                }
            }
        }
    }

    var totalSum = 0

    for (flee in fleas) {
        if (visited[flee.first][flee.second] == -1) {
            output.write("-1")
            output.close()
            return
        }
        totalSum += visited[flee.first][flee.second]
    }

    output.write("$totalSum")
    output.close()
}