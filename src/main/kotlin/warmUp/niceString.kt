package warmUp

import java.io.File

fun niceString() {
    val allInput = File("input.txt").bufferedReader().lineSequence().iterator()

    val k = allInput.next().toInt()
    val string = allInput.next()

    val charMap = hashMapOf<Char, Int>()

    var second = 0
    var sideChars = 0
    var max = 0

    val maxStack = mutableListOf(0)

    for ((first, ch) in string.withIndex()) {

        charMap[ch] = charMap.getOrDefault(ch, 0) + 1
        sideChars++

        if (charMap[ch]!! >= maxStack.last()) {
            maxStack.add(charMap[ch]!!)
        }

        while (sideChars - maxStack.last() > k && second < first) {
            charMap[string[second]] = charMap[string[second]]!! - 1
            sideChars--

            if (charMap[string[second]] == maxStack.last() - 1) {
                maxStack.removeLast()
            }
            if (charMap[string[second]] == 0) {
                charMap.remove(string[second])
            }
            second++
        }
        max = maxOf(max, first - second + 1)
    }

    println(max)
}