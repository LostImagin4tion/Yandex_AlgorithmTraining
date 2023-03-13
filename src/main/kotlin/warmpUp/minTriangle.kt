package warmpUp

import java.io.File

fun minTriangle() {
    val allInput = File("input.txt").bufferedReader().lineSequence().iterator()

    val k = allInput.next().toInt()
    val coords = mutableListOf<Pair<Int, Int>>()

    for (i in 0 until k) {
        val input = allInput.next().split(" ").map { it.toInt() }

        coords.add(Pair(input[0], input[1]))
    }

    val minX = coords.minBy { it.first }.first
    val minY = coords.minBy { it.second }.second
    val maxX = coords.maxBy { it.first }.first
    val maxY = coords.maxBy { it.second }.second

    println("$minX $minY $maxX $maxY")
}