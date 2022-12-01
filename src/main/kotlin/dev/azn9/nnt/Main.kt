package dev.azn9.nnt

const val debug = false
const val learningRate = 0.1

fun main() {
    val network = Network()

    val input = doubleArrayOf(2.0, 3.0)
    val expected = doubleArrayOf(1.0, 0.2)

    println("Input : " + input.joinToString(", "))

    network.setData(input, expected)
    network.initialize(1, 2, 2, 2)

    testInitialization(network)
    network.print()

    println("Output : " + network.output().joinToString(", "))
    println("Cost : " + network.cost())

    network.backPropagation()

    println()
    println("Output : " + network.output().joinToString(", "))
    println("Cost : " + network.cost())

    for (i in 0..10000) {
        network.output()
        network.cost()
        network.backPropagation()
    }

    println()
    println("Output : " + network.output().joinToString(", "))
    println("Cost : " + network.cost())
}

fun testInitialization(network: Network) {
    network.neuronBiases[1] = doubleArrayOf(0.25, 0.45)
    network.neuronBiases[2] = doubleArrayOf(0.15, 0.35)

    network.synapsesWeights[0] = doubleArrayOf(0.3, 0.2, -0.4, 0.6)
    network.synapsesWeights[1] = doubleArrayOf(0.7, -0.3, 0.5, -0.1)
}

