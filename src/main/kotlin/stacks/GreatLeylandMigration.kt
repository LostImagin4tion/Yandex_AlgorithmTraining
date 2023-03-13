package stacks

import java.io.File
import java.util.*

fun greatLeylandMigration() {
    val allInput = File("input.txt").bufferedReader()
        .lineSequence()
        .iterator()

    val n = allInput.next().toInt()
    val input = allInput.next()
        .split(" ")
        .map { it.toInt() }

    val stack = Stack<Int>()
    val result = MutableList(n) { -1 }

    for (i in input.indices) {
        while (stack.isNotEmpty() && input[stack.peek()] > input[i]) {
            result[stack.pop()] = i
        }
        stack.push(i)
    }

    println(result.joinToString(" "))
}