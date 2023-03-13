package dfs

import java.io.File

private fun isCyclicUtil(
    current: Int,
    adjacencyList: List<List<Int>>,
    visited: MutableList<Boolean>,
    stack: MutableList<Boolean>
): Boolean {
    if (stack[current]) {
        return true
    }
    if (visited[current]) {
        return false
    }

    visited[current] = true
    stack[current] = true

    for (vertex in adjacencyList[current]) {
        if (isCyclicUtil(vertex, adjacencyList, visited, stack)) {
            return true
        }
    }
    stack[current] = false
    return false
}

private fun isCyclic(
    adjacencyList: List<List<Int>>
): Boolean {
    val visited = MutableList(adjacencyList.size) { false }
    val stack = MutableList(adjacencyList.size) { false }

    for (vertex in 1 until adjacencyList.size) {
        if (isCyclicUtil(vertex, adjacencyList, visited, stack)) {
            return true
        }
    }
    return false
}

private fun dfs(
    current: Int,
    adjacencyList: List<List<Int>>,
    visited: MutableList<Boolean>,
    result: MutableList<Int>
) {
    for (vertex in adjacencyList[current]) {
        if (!visited[vertex]) {
            visited[vertex] = true
            dfs(
                current = vertex,
                adjacencyList = adjacencyList,
                visited = visited,
                result = result
            )
        }
    }
    result.add(current)
}

fun topologicalSorting() {
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

        adjacencyList[start].add(end)
    }

    if (isCyclic(adjacencyList)) {
        output.write("-1")
    } else {
        val visited = MutableList(n + 1) { false }
        val result = mutableListOf<Int>()

        for (vertex in 1 until adjacencyList.size) {

            if (!visited[vertex]) {
                visited[vertex] = true
                dfs(
                    current = vertex,
                    adjacencyList =  adjacencyList,
                    visited = visited,
                    result = result
                )
            }
        }

        output.write(result.reversed().joinToString(" "))
    }
    output.close()
}