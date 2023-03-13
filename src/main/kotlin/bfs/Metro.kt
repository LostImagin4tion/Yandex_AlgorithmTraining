package bfs

import java.io.File

fun metro() {
    val allInput = File("input.txt").bufferedReader()
        .lineSequence()
        .iterator()

    val output = File("output.txt").bufferedWriter()

    val n = allInput.next().toInt()
    val m = allInput.next().toInt()

    val lines = mutableListOf<MutableList<Int>>()
    val adjacencyList = mutableListOf<MutableList<Int>>()

    for (i in 0 until m) {

        val newLine = allInput.next()
            .trim()
            .split(" ")
            .map { it.toInt() }
            .toMutableList()
        newLine.removeFirst()

        lines.add(newLine)
        adjacencyList.add(mutableListOf())

        for (j in 0 until i) {
            if (newLine.intersect(lines[j].toSet()).isNotEmpty()) {
                adjacencyList[i].add(j)
                adjacencyList[j].add(i)
            }
        }
    }

    val (start, finish) = allInput.next()
        .split(" ")
        .map { it.toInt() }

    val startLines = mutableListOf<Int>()
    val finishLines = mutableListOf<Int>()

    for (i in adjacencyList.indices) {
        if (start in lines[i]) {
            startLines.add(i)
        }
        if (finish in lines[i]) {
            finishLines.add(i)
        }
    }

    val visited = MutableList(m) { -1 }
    val queue = mutableListOf<Pair<Int, Int>>()

    queue.addAll(startLines.map { Pair(it, -1) })

    while (queue.isNotEmpty()) {
        val current = queue.removeFirst()

        if (visited[current.first] == -1 || visited[current.first] > current.second + 1) {
            visited[current.first] = current.second + 1

            for (lineIndex in adjacencyList[current.first]) {
                queue.add(Pair(lineIndex, current.second + 1))
            }
        }
    }

    var min = Int.MAX_VALUE

    for (finishLine in finishLines) {
        min = minOf(visited[finishLine], min)
    }

    output.write("$min")
    output.close()
}