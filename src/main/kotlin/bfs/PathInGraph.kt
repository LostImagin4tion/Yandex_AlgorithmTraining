package bfs

import java.io.File

fun pathInGraph() {
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

    val visited = MutableList(n + 1) { Pair(-1, -1) }
    val queue = mutableListOf<Pair<Int, Int>>()

    queue.add(Pair(first, 0))

    while (queue.isNotEmpty()) {
        val current = queue.removeFirst()

        if (visited[current.first].first == -1) {
            visited[current.first] = Pair(
                visited[current.second].first + 1,
                current.second
            )

            for (vertex in adjacencyList[current.first]) {
                if (visited[vertex].first == -1) {
                    queue.add(Pair(vertex, current.first))
                }
            }
        }
    }

    output.write("${visited[last].first}\n")

    if (visited[last].first > 0) {
        val route = mutableListOf(last)
        var ancestor = visited[last].second

        while (ancestor != 0) {
            route.add(ancestor)
            ancestor = visited[ancestor].second
        }

        output.write(route.reversed().joinToString(" "))
    }

    output.close()
}