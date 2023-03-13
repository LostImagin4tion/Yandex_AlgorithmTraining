package warmUp

import java.io.File
import kotlin.math.abs

fun controlWork() {
    val allInput = File("input.txt").bufferedReader().lineSequence().iterator()

    val students = allInput.next().toInt()
    val variants = allInput.next().toInt()

    val petyaRow = allInput.next().toInt()
    val petyaPlace = allInput.next().toInt()

    val petyaIndex = petyaRow * 2 - petyaPlace % 2

    val vasyaVar1 = petyaIndex - variants
    val vasyaVar2 = petyaIndex + variants

    val vasyaRow1 = vasyaVar1 / 2 + vasyaVar1 % 2
    val vasyaRow2 = vasyaVar2 / 2 + vasyaVar2 % 2

    if (vasyaVar1 > 0 && (vasyaVar2 > students || abs(petyaRow - vasyaRow1) < abs(petyaRow - vasyaRow2))) {
        println("$vasyaRow1 ${2 - vasyaVar1 % 2}")
    }
    else if (vasyaVar2 <= students) {
        println("$vasyaRow2 ${2 - vasyaVar2 % 2}")
    }
    else {
        println(-1)
    }
}