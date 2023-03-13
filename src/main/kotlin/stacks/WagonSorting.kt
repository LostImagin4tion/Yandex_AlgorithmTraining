package stacks

import java.io.File
import java.util.*

fun wagonSorting() {
    val allInput = File("input.txt").bufferedReader()
        .lineSequence()
        .iterator()

    val n = allInput.next().toInt()
    val trains = allInput.next()
        .split(" ")
        .map { it.toInt() }
        .reversed()

    val inputStack = Stack<Int>()
    val middleStack = Stack<Int>()
    val resultStack = Stack<Int>()

    inputStack.addAll(trains)
    resultStack.add(0)

    while (inputStack.isNotEmpty()) {
        val inputTrain = inputStack.pop()

        if (resultStack.peek() + 1 == inputTrain) {
            resultStack.push(inputTrain)

            while (middleStack.isNotEmpty() && middleStack.peek() == resultStack.peek() + 1) {
                resultStack.add(middleStack.pop())
            }
        }
        else {
            middleStack.push(inputTrain)
        }
    }

    while (middleStack.isNotEmpty()) {
        val middleTrain = middleStack.pop()

        if (resultStack.peek() + 1 == middleTrain) {
            resultStack.push(middleTrain)
        } else {
            println("NO")
            return
        }
    }

    println("YES")
}