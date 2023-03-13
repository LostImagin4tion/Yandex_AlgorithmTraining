package warmpUp

import java.io.File
import java.time.Duration
import java.time.LocalTime
import java.time.format.DateTimeFormatter

fun sntp() {
    val allInput = File("input.txt").bufferedReader().lineSequence().iterator()

    val format = DateTimeFormatter.ofPattern("HH:mm:ss")

    val aTime = LocalTime.parse(allInput.next(), format)
    val bTime = LocalTime.parse(allInput.next(), format)
    val cTime = LocalTime.parse(allInput.next(), format)

    var aIncrement = Duration.between(aTime, cTime)

    if (aIncrement.isNegative) {
        aIncrement = aIncrement.plusHours(24)
    }

    aIncrement = if (aIncrement.toSecondsPart() % 2 == 1) {
        aIncrement.dividedBy(2).plusSeconds(1)
    } else {
        aIncrement.dividedBy(2)
    }

    val result = bTime.plus(aIncrement)

    println(format.format(result))
}