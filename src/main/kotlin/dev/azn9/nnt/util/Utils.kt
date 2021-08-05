package dev.azn9.nnt.util

import dev.azn9.nnt.debug
import kotlin.math.exp

operator fun DoubleArray.plus(d: Double): DoubleArray {
    val clone = this.clone()

    for (i in 0 until this.size) {
        clone[i] += d
    }

    return clone
}

operator fun DoubleArray.plus(d: Int): DoubleArray {
    val clone = this.clone()

    for (i in 0 until this.size) {
        clone[i] += d.toDouble()
    }

    return clone
}

operator fun DoubleArray.times(d: Double): DoubleArray {
    val clone = this.clone()

    for (i in 0 until this.size) {
        clone[i] *= d
    }

    return clone
}

operator fun DoubleArray.times(d: Int): DoubleArray {
    val clone = this.clone()

    for (i in 0 until this.size) {
        clone[i] *= d.toDouble()
    }

    return clone
}

fun sigmoid(input: Double): Double {
    return 1 / (1 + exp(-input))
}

fun debugPrintln() {
    if (debug)
        println()
}

fun debugPrintln(any: Any) {
    if (debug)
        println(any)
}