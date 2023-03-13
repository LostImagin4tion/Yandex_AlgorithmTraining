package warmUp

import java.io.File

fun boringLecture() {
    val allInput = File("input.txt").bufferedReader()
        .lineSequence()
        .iterator()

    val string = allInput.next()
    val lettersMap = sortedMapOf<Char, Long>()

    for ((index, char) in string.withIndex()) {
        lettersMap[char] = lettersMap.getOrDefault(char, 0) + (string.length - index).toLong() * (index + 1)
    }

    println(lettersMap.entries.joinToString(separator = "") { "${it.key}: ${it.value}\n" })

}