package queues

import java.io.File

fun pyramidSort() {
    val allInput = File("input.txt").bufferedReader()
        .lineSequence()
        .iterator()

    val output = File("output.txt").bufferedWriter()

    val n = allInput.next().toInt()
    val array = allInput.next().split(" ").map { it.toInt() }.toIntArray()

    buildMaxHeap(array)

    for (i in array.size - 1 downTo 1) {
        val temp = array[0]
        array[0] = array[i]
        array[i] = temp
        maxHeapify(array, 0, i - 1)
    }

    output.write(array.joinToString(" "))
    output.close()
}

private fun buildMaxHeap(array: IntArray) {
    for (i in ((array.size/2) - 1) downTo 0) {
        maxHeapify(array, i)
    }
}

private fun maxHeapify(array: IntArray, rootIndex: Int, heapSize: Int = array.size - 1) {

    val leftChildIndex = (2 * rootIndex) + 1
    val rightChildIndex = (2 * rootIndex) + 2
    var largestElementIndex = rootIndex

    if (leftChildIndex <= heapSize && array[leftChildIndex] > array[rootIndex]) {
        largestElementIndex = leftChildIndex
    }

    if (rightChildIndex <= heapSize && array[rightChildIndex] > array[largestElementIndex]) {
        largestElementIndex = rightChildIndex
    }

    if (largestElementIndex != rootIndex) {
        val temp = array[rootIndex]
        array[rootIndex] = array[largestElementIndex]
        array[largestElementIndex] = temp
        maxHeapify(array, largestElementIndex, heapSize)
    }
}

