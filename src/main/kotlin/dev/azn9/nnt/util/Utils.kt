package dev.azn9.nnt.util

import kotlin.math.exp

operator fun DoubleArray.plus(d: Double): DoubleArray {
    for (i in 0 until this.size) {
        this[i] += d
    }

    return this
}

operator fun DoubleArray.plus(d: Int): DoubleArray {
    for (i in 0 until this.size) {
        this[i] += d.toDouble()
    }

    return this
}

operator fun DoubleArray.times(d: Double): DoubleArray {
    for (i in 0 until this.size) {
        this[i] *= d
    }

    return this
}

operator fun DoubleArray.times(d: Int): DoubleArray {
    for (i in 0 until this.size) {
        this[i] *= d.toDouble()
    }

    return this
}

fun sigmoid(input: Double): Double {
    return 1 / (1 + exp(-input))
}