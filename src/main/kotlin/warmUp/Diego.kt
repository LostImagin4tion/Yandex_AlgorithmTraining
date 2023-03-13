package warmUp

import java.io.File

fun diego() {
    val allInput = File("input.txt").bufferedReader().lineSequence().iterator()

    val n = allInput.next().toInt()
    val diego = allInput.next().split(" ")
        .distinct()
        .map { it.toInt() }
        .sorted()

    val k = allInput.next().toInt()
    val collectors = allInput.next().split(" ")
        .map { it.toInt() }

    var left: Int
    var right: Int

    for (collectorCard in collectors) {
        left = 0
        right = diego.size

        while (left < right) {
            val middle = (left + right + 1) / 2

            if (middle < diego.size && diego[middle] < collectorCard) {
                left = middle
            } else {
                right = middle - 1
            }
        }

        if (diego[left] < collectorCard) {
            println(left + 1)
        } else {
            println(0)
        }
    }
}