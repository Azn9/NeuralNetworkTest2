package dev.azn9.nnt

import java.util.*
import kotlin.collections.ArrayList

val input = doubleArrayOf(2.0, 3.0)

fun main() {
    val network = Network()

    network.initialize(1, 2, 2, 2)

    testInitialization(network)

    network.output()
}

fun testInitialization(network: Network) {
    network.neuronBiases[1] = doubleArrayOf(0.25, 0.45)
    network.neuronBiases[2] = doubleArrayOf(0.15, 0.35)

    network.synapses[0] = doubleArrayOf(0.3, 0.2, -0.4, 0.6)
    network.synapses[1] = doubleArrayOf(0.7, -0.3, 0.5, -0.1)
}

data class Network(
    val neuronOutput: ArrayList<DoubleArray>,
    val neuronRawOutput: ArrayList<DoubleArray>,
    val neuronBiases: ArrayList<DoubleArray>,
    val synapses: ArrayList<DoubleArray>
) {

    constructor() : this(ArrayList(), ArrayList(), ArrayList(), ArrayList())

    fun initialize(hiddenLayerCount: Int, inputNeuronCount: Int, hiddenLayerNeuronCount: Int, outputNeuronCount: Int) {
        assert(input.size == inputNeuronCount)

        neuronOutput.add(DoubleArray(inputNeuronCount) { i -> input[i] })
        neuronBiases.add(DoubleArray(inputNeuronCount) { 0.0 })

        for (i in 0..inputNeuronCount) {
            neuronBiases[0][i] = random.nextDouble()
        }

        for (i in 0..hiddenLayerCount) {
            neuronOutput.add(DoubleArray(hiddenLayerNeuronCount) { 0.0 })
            neuronBiases.add(DoubleArray(hiddenLayerNeuronCount) { 0.0 })

            for (j in 0..hiddenLayerNeuronCount) {
                neuronBiases[i + 1][i] = random.nextDouble()
            }
        }

        neuronOutput.add(DoubleArray(outputNeuronCount) { 0.0 })
        neuronBiases.add(DoubleArray(outputNeuronCount) { 0.0 })

        for (i in 0..outputNeuronCount) {
            neuronBiases[neuronBiases.size - 1][i] = random.nextDouble()
        }

        synapses.add(DoubleArray(inputNeuronCount * hiddenLayerNeuronCount) { 0.0 })
        for (i in 0 until hiddenLayerCount) {
            synapses.add(DoubleArray(hiddenLayerNeuronCount * hiddenLayerNeuronCount) { 0.0 })
        }
        synapses.add(DoubleArray(hiddenLayerNeuronCount * outputNeuronCount) { 0.0 })
    }

    fun output(): DoubleArray {

    }

    companion object {
        val random = Random(0)
    }

}