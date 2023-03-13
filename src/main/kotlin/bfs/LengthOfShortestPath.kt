package bfs

import java.io.File

fun lengthOfShortesPath() {
    val allInput = File("input.txt").bufferedReader()
        .lineSequence()
        .iterator()

    val output = File("output.txt").bufferedWriter()

    val n = allInput.next().toInt()

    val adjacencyList = MutableList(n + 1) { listOf<Int>() }

    for (i in 1 until n + 1) {
        val adjacencyRow = allInput.next()
            .trim()
            .split(" ")
            .map { it.toInt() }

        val indices = adjacencyRow
            .indices
            .toList()
            .filter { adjacencyRow[it] != 0 }
            .map { it + 1 }

        adjacencyList[i] = indices
    }

    val (first, last) = allInput.next()
        .trim()
        .split(" ")
        .map { it.toInt() }

    val visited = MutableList(n + 1) { -1 }
    val queue = mutableListOf<Pair<Int, Int>>()

    queue.add(Pair(first, 0))

    while (queue.isNotEmpty()) {
        val current = queue.removeFirst()

        if (visited[current.first] == -1) {
            visited[current.first] = visited[current.second] + 1

            for (vertex in adjacencyList[current.first]) {
                if (visited[vertex] == -1) {
                    queue.add(Pair(vertex, current.first))
                }
            }
        }
    }

    output.write("${visited[last]}")
    output.close()
}