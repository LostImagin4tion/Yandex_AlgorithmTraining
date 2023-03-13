package queues

import java.io.File

fun queueWithErrorProtection() {
    val allInput = File("input.txt").bufferedReader()
        .lineSequence()
        .iterator()

    val output = File("output.txt").bufferedWriter()

    val queue = mutableListOf<Int>()

    while (allInput.hasNext()) {
        val input = allInput.next().split(" ")

        if (input[0] == "push") {
            queue.add(input[1].toInt())
            output.write("ok\n")
        }
        else if (input[0] == "pop") {
            if (queue.isNotEmpty()) {
                output.write("${queue.removeFirst()}\n")
            } else {
                output.write("error\n")
            }
        }
        else if (input[0] == "front") {
            if (queue.isNotEmpty()) {
                output.write("${queue[0]}\n")
            } else {
                output.write("error\n")
            }
        }
        else if (input[0] == "size") {
            output.write("${queue.size}\n")
        }
        else if (input[0] == "clear") {
            queue.clear()
            output.write("ok\n")
        }
        else if (input[0] == "exit") {
            output.write("bye")
            output.close()
            return
        }
    }
}