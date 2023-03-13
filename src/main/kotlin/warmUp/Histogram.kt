package warmUp

fun histogram() {
    val input = generateSequence(::readLine).toList().joinToString("")
    var maxElem = -1

    val frequency = hashMapOf<Char, Int>()

    for (char in input) {
        if (!char.isWhitespace()) {
            frequency[char] = frequency.getOrDefault(char, 0) + 1

            frequency[char]?.let { maxElem = maxOf(maxElem, it) }
        }
    }

    val sortedFrequency = frequency.toSortedMap { o1, o2 -> o1 - o2 }

    for (i in maxElem downTo 1) {
        for (count in sortedFrequency.values) {
            if (count >= i) {
                print('#')
            } else {
                print(' ')
            }
        }
        println()
    }
    print(sortedFrequency.keys.joinToString(""))
}