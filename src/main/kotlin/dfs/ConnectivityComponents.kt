package dfs

import java.io.File

private fun dfs(
    current: Int,
    adjacencyList: List<List<Int>>,
    visited: MutableList<Boolean>,
    connectivityComponent: MutableList<Int>
) {
    for (i in adjacencyList[current].indices) {
        if (!visited[adjacencyList[current][i]]) {
            visited[adjacencyList[current][i]] = true
            connectivityComponent.add(adjacencyList[current][i])

            dfs(
                current = adjacencyList[current][i],
                adjacencyList = adjacencyList,
                visited = visited,
                connectivityComponent = connectivityComponent
            )
        }
    }
}

fun connectivityComponents() {
    val allInput = File("input.txt").bufferedReader()
        .lineSequence()
        .iterator()

    val output = File("output.txt").bufferedWriter()

    val (n, m) = allInput.next()
        .split(" ")
        .map { it.toInt() }

    val adjacencyList = List(n + 1) { mutableListOf<Int>() }

    for (i in 0 until m) {
        val (start, end) = allInput.next()
            .trim()
            .split(" ")
            .map { it.toInt() }

        if (start != end && start !in adjacencyList[end]) {
            adjacencyList[start].add(end)
            adjacencyList[end].add(start)
        }
    }

    val visited = MutableList(n + 1) { false }
    val result = mutableListOf<MutableList<Int>>()

    for (i in 1 until adjacencyList.size) {

        if (!visited[i]) {
            result.add(mutableListOf(i))
            visited[i] = true

            dfs(
                current = i,
                adjacencyList = adjacencyList,
                visited = visited,
                connectivityComponent = result.last()
            )
        }
    }


    output.write("${result.size}\n")
    for (i in result.indices) {
        output.write("${result[i].size}\n")
        output.write("${result[i].joinToString(" ")}\n")
    }
    output.close()
}