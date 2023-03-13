package stacks

import java.io.File
import java.util.*

fun correctParenthesisSequence() {
    val allInput = File("input.txt").bufferedReader().lineSequence().iterator()

    val input = allInput.next()
    val stack = Stack<Char>()

    for (ch in input) {
        if (ch == '(' || ch == '[' || ch == '{') {
            stack.push(ch)
        }
        else if (stack.isNotEmpty()) {
            if (ch == ')' && stack.peek() == '(') {
                stack.pop()
            }
            else if (ch == ']' && stack.peek() == '[') {
                stack.pop()
            }
            else if (ch == '}' && stack.peek() == '{') {
                stack.pop()
            } else {
                println("no")
                return
            }
        } else {
            println("no")
            return
        }
    }

    if (stack.isEmpty()) {
        println("yes")
    } else {
        println("no")
    }
}