package finalContest

import java.io.File

fun undergroundDelivery() {
    val allInput = File("input.txt").bufferedReader()
        .lineSequence()
        .iterator()

    val output = File("output.txt").bufferedWriter()

    val n = allInput.next().toInt()

    val goods = hashMapOf<String, Long>()
    val train = mutableListOf<Pair<String, Long>>()

    for (i in 0 until n) {
        val input = allInput.next()
            .trim()
            .split(" ")

        if (input[0] == "add") {
            val number = input[1].toLong()

            if (train.isEmpty() || train.last().first != input[2]) {
                train.add(Pair(input[2], number))
            }
            else {
                train[train.lastIndex] = Pair(
                    input[2],
                    train[train.lastIndex].second + number
                )
            }

            goods[input[2]] = goods.getOrDefault(input[2], 0) + number
        }
        else if (input[0] == "get") {
            output.write("${goods.getOrDefault(input[1], 0)}\n")
        }
        else {
            var numberToDelete = input[1].toLong()

            while (numberToDelete >= 0 && train.isNotEmpty()) {
                val lastItem = train.last().first
                val count = train.last().second

                if (numberToDelete >= count) {
                    goods[lastItem] = goods[lastItem]!! - count
                    train.removeLast()
                }
                else {
                    goods[lastItem] = goods[lastItem]!! - numberToDelete
                    train[train.lastIndex] = Pair(
                        lastItem,
                        count - numberToDelete
                    )
                }

                numberToDelete -= count
            }
        }
    }
    output.close()
}