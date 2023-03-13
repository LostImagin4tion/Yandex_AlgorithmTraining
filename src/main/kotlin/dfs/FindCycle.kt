package dfs

import java.io.File

private fun isCyclicUtil(
    current: Int,
    adjacencyList: List<List<Int>>,
    colors: MutableList<Int>,
    parent: Int,
    cyclePath: MutableList<Int>
): Boolean {
    colors[current] = 1

    for (vertex in adjacencyList[current]) {
        if (colors[vertex] == 0) {
            val isCyclic = isCyclicUtil(
                current = vertex,
                adjacencyList = adjacencyList,
                colors = colors,
                parent = current,
                cyclePath = cyclePath
            )

            if (isCyclic) {
                if (cyclePath.first() == cyclePath.last() && cyclePath.size != 1) {
                    return true
                }

                cyclePath.add(vertex)
                return true
            }
        }
        else if (colors[vertex] == 1 && vertex != parent) {
            cyclePath.add(vertex)
            return true
        }
    }

    colors[current] = 2
    return false
}

private fun isCyclic(
    adjacencyList: List<List<Int>>,
    cycle: MutableList<Int>
) {
    /**
     * colors:
     * 0 if vertex is not visited
     * 1 if vertex is visited but not all of its children are visited
     * 2 if vertex and all of its children are visited
     */
    val colors = MutableList(adjacencyList.size) { 0 }

    for (vertex in 1 until adjacencyList.size) {
        if (colors[vertex] == 0) {
            val isCyclic = isCyclicUtil(
                current = vertex,
                adjacencyList = adjacencyList,
                colors = colors,
                parent = vertex,
                cyclePath = cycle
            )

            if (isCyclic) {
                return
            }
        }
    }
}

fun findCycle() {
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

    var cyclePath = mutableListOf<Int>()

    isCyclic(adjacencyList, cyclePath)

    cyclePath = cyclePath.distinct().toMutableList()

    if (cyclePath.isNotEmpty()) {
        output.write("YES\n")
        output.write("${cyclePath.size}\n")
        output.write(cyclePath.joinToString(" "))
    } else {
        output.write("NO")
    }
    output.close()
}