package stacks

import java.io.File
import java.util.*

fun stackWithErrorProtection() {
    val allInput = File("input.txt").bufferedReader()
        .lineSequence()
        .iterator()

    val stack = Stack<Int>()

    while (allInput.hasNext()) {
        val input = allInput.next().split(" ")

        if (input[0] == "push") {
            stack.push(input[1].toInt())
            println("ok")
        }
        else if (input[0] == "pop") {
            if (stack.isNotEmpty()) {
                println(stack.peek())
                stack.pop()
            } else {
                println("error")
            }
        }
        else if (input[0] == "back") {
            if (stack.isNotEmpty()) {
                println(stack.peek())
            } else {
                println("error")
            }
        }
        else if (input[0] == "size") {
            println(stack.size)
        }
        else if (input[0] == "clear") {
            stack.clear()
            println("ok")
        }
        else if (input[0] == "exit") {
            println("bye")
            return
        }
    }
}