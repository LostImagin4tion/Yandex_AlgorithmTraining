package dfs

import java.io.File

private fun dfs(
    current: Int,
    adjacencyList: List<List<Int>>,
    colors: MutableList<Int>,
    color: Int
): Int {
    colors[current] = color

    for (vertex in adjacencyList[current]) {
        if (colors[vertex] == -1) {
            val out = dfs(
                current = vertex,
                adjacencyList = adjacencyList,
                colors = colors,
                color = 3 - color
            )

            if (out == -1) {
                return out
            }
        }
        else if (colors[vertex] == colors[current]) {
            return -1
        }
    }

    return 1
}

fun cheating() {
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
        adjacencyList[end].add(start)
    }

    val colors = MutableList(n + 1) { -1 }

    for (vertex in 1 until adjacencyList.size) {

        if (colors[vertex] == -1) {
            val out = dfs(
                current = vertex,
                adjacencyList = adjacencyList,
                colors = colors,
                color = 1
            )

            if (out == -1) {
                output.write("NO")
                output.close()
                return
            }
        }
    }

    output.write("YES")
    output.close()
}