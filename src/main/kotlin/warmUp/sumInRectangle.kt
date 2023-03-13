package warmUp

import java.io.File
import java.io.Serializable

data class PointPair<out A>(
    val x1: A,
    val y1: A,
    val x2: A,
    val y2: A
): Serializable {
    override fun toString(): String = "(($x1, $y1), ($x2, $y2))"
}

fun sumInRectangle() {
    val allInput = File("input.txt").bufferedReader().lineSequence().iterator()

    val (n, m, k) = allInput.next().split(" ").map { it.toInt() }

    val matrix = mutableListOf<List<Int>>()
    val requests = mutableListOf<PointPair<Int>>()
    val result = mutableListOf<Int>()

    for (i in 0 until n) {
        matrix.add(
            allInput.next()
                .trim()
                .split(" ")
                .map { it.toInt() }
        )
    }
    for (i in 0 until k) {
        val points = allInput.next()
            .trim()
            .split(" ")
            .map { it.toInt() - 1 }

        requests.add(PointPair(points[0], points[1], points[2], points[3]))
    }

    // calculate prefix sum matrix
    val prefixSums = List(n) { MutableList(m) {0} }
    prefixSums[0][0] = matrix[0][0]

    for (i in 1 until prefixSums.size) {
        prefixSums[i][0] = prefixSums[i - 1][0] + matrix[i][0]
    }
    for (i in 1 until prefixSums[0].size) {
        prefixSums[0][i] = prefixSums[0][i - 1] + matrix[0][i]
    }
    for (i in 1 until prefixSums.size) {
        for (j in 1 until prefixSums[i].size) {
            prefixSums[i][j] = prefixSums[i - 1][j] + prefixSums[i][j - 1] + matrix[i][j] - prefixSums[i - 1][j - 1]
        }
    }

    // calculate requests
    for (points in requests) {
        if (points.x1 == points.x2 && points.y1 == points.y2) {
            result.add(matrix[points.x1][points.y1])
        } else {
            var requestedSum = prefixSums[points.x2][points.y2]

            if (points.y1 - 1 >= 0) {
                requestedSum -= prefixSums[points.x2][points.y1 - 1]
            }
            if (points.x1 - 1 >= 0) {
                requestedSum -= prefixSums[points.x1 - 1][points.y2]
            }
            if (points.x1 - 1 >= 0 && points.y1 - 1 >= 0) {
                requestedSum += prefixSums[points.x1 - 1][points.y1 - 1]
            }

            result.add(requestedSum)
        }
    }

    println(result.joinToString(separator = "") { "$it\n" })
}