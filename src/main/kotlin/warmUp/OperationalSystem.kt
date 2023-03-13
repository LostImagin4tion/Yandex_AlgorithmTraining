package warmUp

import java.io.File
import java.util.*

fun operationalSystem() {
    val allInput = File("input.txt").bufferedReader().lineSequence().iterator()

    val diskSize = allInput.next().toInt()
    val partitionsNumber = allInput.next().toInt()

    val partitions = TreeSet<Pair<Int, Int>> { o1, o2 -> o1.first - o2.first + o1.second - o2.second }

    for (i in 0 until partitionsNumber) {
        val input = allInput.next().split(" ").map { it.toInt() }

        val partitionsToRemove = mutableListOf<Pair<Int, Int>>()

        for (partition in partitions) {
            if (!(input[1] < partition.first || input[0] > partition.second)) {
                partitionsToRemove.add(partition)
            }
        }
        partitions.removeAll(partitionsToRemove.toSet())
        partitions.add(Pair(input[0], input[1]))
    }

    println(partitions.size)
}