package queues

import java.io.File
import kotlin.math.pow

fun drunkGame() {
    val allInput = File("input.txt").bufferedReader()
        .lineSequence()
        .iterator()

    val output = File("output.txt").bufferedWriter()

    var counter = 0
    val first = allInput.next().trim().split(" ").map { it.toInt() }.toMutableList()
    val second = allInput.next().trim().split(" ").map { it.toInt() }.toMutableList()

    while (first.isNotEmpty() && second.isNotEmpty()) {
        if (counter.toDouble() == 10.0.pow(6)) {
            output.write("botva")
            output.close()
            return
        }

        val cardOfFirst = first.removeFirst()
        val cardOfSecond = second.removeFirst()

        if ((cardOfFirst == 0 && cardOfSecond == 9)) {
            first.add(cardOfFirst)
            first.add(cardOfSecond)
        }
        else if (cardOfSecond == 0 && cardOfFirst == 9) {
            second.add(cardOfFirst)
            second.add(cardOfSecond)
        }
        else if (cardOfFirst > cardOfSecond) {
            first.add(cardOfFirst)
            first.add(cardOfSecond)
        }
        else {
            second.add(cardOfFirst)
            second.add(cardOfSecond)
        }
        counter++
    }

    if (first.isEmpty()) {
        output.write("second $counter")
    } else {
        output.write("first $counter")
    }
    output.close()
}