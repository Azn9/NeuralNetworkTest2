package dev.azn9.nnt.tests

import dev.azn9.nnt.Network
import dev.azn9.nnt.Network.Companion.random
import java.util.*

fun main() {
    val network = Network()

    var input = doubleArrayOf(0.1)
    var expected = doubleArrayOf(0.0, 1.0)

    println("Input : " + input.joinToString(", "))

    network.setData(input, expected)
    network.initialize(1, 1, 2, 2)

    println("Output : " + network.output().joinToString(", "))
    println("Cost : " + network.cost())

    network.backPropagation()

    println()
    println("Output : " + network.output().joinToString(", "))
    println("Cost : " + network.cost())

    for (j in 0..1000) {
        val entier = random.nextInt(10)
        val number = entier / 10.0
        val isPair = if (entier % 2 == 0) 1.0 else 0.0
        val isImpair = 1.0 - isPair

        println("$entier : $isPair / $isImpair")

        input = doubleArrayOf(number)
        expected = doubleArrayOf(isPair, isImpair)

        network.setData(input, expected)

        for (i in 0..1000) {
            network.output()
            network.cost()
            network.backPropagation()
        }
    }

    println()
    println("Output : " + network.output().joinToString(", "))
    println("Cost : " + network.cost())

    while (true) {
        println("Entrez un nombre entre 0 et 9 (inclus) > ")
        val toTest = Scanner(System.`in`).nextInt()

        val number = toTest / 10.0
        val isPair = if (toTest % 2 == 0) 1.0 else 0.0
        val isImpair = 1.0 - isPair

        input = doubleArrayOf(number)
        expected = doubleArrayOf(isPair, isImpair)

        network.setData(input, expected)

        val output = network.output()

        println()
        println("Output : " + output.joinToString(", "))
        println("Cost : " + network.cost())
        println(if (output[0] + 0.01 > 1) "PAIR !" else "IMPAIR !")
        println()
        println()
    }
}