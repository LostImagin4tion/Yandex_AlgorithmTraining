package stacks

import java.io.File
import java.util.*

fun postfixNotation() {
    val allInput = File("input.txt").bufferedReader()
        .lineSequence()
        .iterator()

    val input = allInput.next().trim().split(" ")
    val stack = Stack<Int>()

    for (string in input) {
        val symbol = string.toIntOrNull()

        if (symbol != null) {
            stack.push(symbol)
        }
        else if (stack.size > 1) {
            val digit1 = stack.pop()
            val digit2 = stack.pop()

            val result = when(string) {
                "-" -> digit2 - digit1
                "+" -> digit2 + digit1
                else -> digit2 * digit1
            }
            stack.push(result)
        }
    }

    println(stack.peek())
}