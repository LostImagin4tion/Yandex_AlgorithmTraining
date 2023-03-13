package warmUp

import java.io.File

fun goodString() {
    val allInput = File("input.txt").bufferedReader().lineSequence().iterator()

    val n = allInput.next().toInt()
    val lettersCount = mutableListOf<Int>()

    for (i in 0 until n) {
        lettersCount.add(allInput.next().toInt())
    }

    var isNotEmpty = true
    var maxGood = 0

    if (lettersCount.all { it == lettersCount[0] }) {
        println(lettersCount[0].toLong() * (lettersCount.size - 1).toLong())
    } else {
        while (isNotEmpty) {
            isNotEmpty = false

            for (i in 0 until lettersCount.lastIndex) {
                if (lettersCount[i] > 0) {
                    if (lettersCount[i + 1] > 0) {
                        maxGood++
                        isNotEmpty = true

                        lettersCount[i]--
                        if (i == lettersCount.lastIndex - 1) {
                            lettersCount[i + 1]--
                        }
                    }
                    else if (i > 0 && lettersCount[i - 1] > 0) {
                        lettersCount[i]--
                    }
                }
            }
        }

        println(maxGood)
    }
}