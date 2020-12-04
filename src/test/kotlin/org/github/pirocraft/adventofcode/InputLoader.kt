package org.github.pirocraft.adventofcode

object InputLoader {
    fun loadInput(name: String) = javaClass.classLoader
        .getResource("$name.txt").readText()

}