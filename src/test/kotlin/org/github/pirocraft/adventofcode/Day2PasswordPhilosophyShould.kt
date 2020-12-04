package org.github.pirocraft.adventofcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Day2PasswordPhilosophyShould {
    private val passwordPhilosophy = PasswordPhilosophy()

    @Test
    internal fun `how many password are valid`() {
        assertEquals(2, passwordPhilosophy.howManyPasswordsAreValid(passwordsExample.split("\n")))
        assertEquals(
            542,
            passwordPhilosophy.howManyPasswordsAreValid(InputLoader.loadInput("passwordsInput").split("\n"))
        )
    }

    class PasswordPhilosophy {
        fun howManyPasswordsAreValid(passwords: List<String>): Int = passwords
            .filter {
                it.split(" ").let {
                    extractPasswordPolicy(it).validPassword(it[2])
                }
            }.count()

        private fun extractPasswordPolicy(serializedPolicy: List<String>) =
            PasswordPolicy(
                serializedPolicy[0].split("-").let { Pair(it[0].toInt(), it[1].toInt()) },
                serializedPolicy[1][0]
            )

    }

    data class PasswordPolicy(val range: Pair<Int, Int>, val character: Char) {
        fun validPassword(password: String): Boolean = password
            .count { it == character }
            .let { it >= range.first && it <= range.second }
    }

    val passwordsExample = "1-3 a: abcde\n" +
            "1-3 b: cdefg\n" +
            "2-9 c: ccccccccc"
}