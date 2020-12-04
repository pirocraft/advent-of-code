package org.github.pirocraft.adventofcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Day2PasswordPhilosophyShould {
    private val passwordPhilosophy = UnofficialAuthenticationSystem()
    private val officialAuthenticationSystem = OfficialAuthenticationSystem()

    @Test
    internal fun `count how many password are valid with the unofficial policy`() {
        assertEquals(2, passwordPhilosophy.howManyPasswordsAreValid(passwordsExample.split("\n")))
        assertEquals(
            542,
            passwordPhilosophy.howManyPasswordsAreValid(InputLoader.loadInput("passwordsInput").split("\n"))
        )
    }

    @Test
    internal fun `count how many password are valid with the official policy`() {
        assertEquals(1, officialAuthenticationSystem.howManyPasswordsAreValid(passwordsExample.split("\n")))
        assertEquals(
            360,
            officialAuthenticationSystem.howManyPasswordsAreValid(InputLoader.loadInput("passwordsInput").split("\n"))
        )
    }

    abstract class AuthenticationSystem {
        fun howManyPasswordsAreValid(passwords: List<String>): Int = passwords
            .filter { it ->
                it.split(" ").let {
                    passwordPolicy(it).validPassword(it[2])
                }
            }.count()

        abstract fun passwordPolicy(it: List<String>): PasswordPolicy
    }

    class UnofficialAuthenticationSystem : AuthenticationSystem() {
        override fun passwordPolicy(it: List<String>) = UnofficialPasswordPolicy(it)
    }

    class OfficialAuthenticationSystem : AuthenticationSystem() {
        override fun passwordPolicy(it: List<String>) = OfficialPasswordPolicy(it)
    }

    abstract class PasswordPolicy(serializedPolicy: List<String>) {
        val range = serializedPolicy[0].split("-").let { Pair(it[0].toInt(), it[1].toInt()) }
        val character = serializedPolicy[1][0]

        abstract fun validPassword(password: String): Boolean
    }

    data class UnofficialPasswordPolicy(private val serializedPolicy: List<String>) : PasswordPolicy(serializedPolicy) {
        override fun validPassword(password: String): Boolean = password
            .count { it == character }
            .let { it >= range.first && it <= range.second }
    }

    data class OfficialPasswordPolicy(private val serializedPolicy: List<String>) : PasswordPolicy(serializedPolicy) {
        override fun validPassword(password: String): Boolean = password
            .filterIndexed { index, c -> (index + 1 == range.first || index + 1 == range.second) && c == character }
            .let { it.length == 1 }
    }

    private val passwordsExample = "1-3 a: abcde\n" +
            "1-3 b: cdefg\n" +
            "2-9 c: ccccccccc"
}