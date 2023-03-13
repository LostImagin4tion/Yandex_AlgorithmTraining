package queues

import java.io.File

fun dequeWithErrorProtection() {
    val allInput = File("input.txt").bufferedReader()
        .lineSequence()
        .iterator()

    val output = File("output.txt").bufferedWriter()

    val queue = mutableListOf<Int>()

    while (allInput.hasNext()) {
        val input = allInput.next().split(" ")

        if (input[0] == "push_front") {
            queue.add(0, input[1].toInt())
            output.write("ok\n")
        }
        else if (input[0] == "push_back") {
            queue.add(input[1].toInt())
            output.write("ok\n")
        }
        else if (input[0] == "pop_front") {
            if (queue.isNotEmpty()) {
                output.write("${queue.removeFirst()}\n")
            } else {
                output.write("error\n")
            }
        }
        else if (input[0] == "pop_back") {
            if (queue.isNotEmpty()) {
                output.write("${queue.removeLast()}\n")
            } else {
                output.write("error\n")
            }
        }
        else if (input[0] == "front") {
            if (queue.isNotEmpty()) {
                output.write("${queue.first()}\n")
            } else {
                output.write("error\n")
            }
        }
        else if (input[0] == "back") {
            if (queue.isNotEmpty()) {
                output.write("${queue.last()}\n")
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