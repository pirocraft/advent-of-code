package org.github.pirocraft.adventofcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

const val TREE = '#'

class Day3TrajectoryShould {
    private val tobogganOnExample = Toboggan(mapExample.split("\n"))

    @Test
    internal fun `count trees met during descent`() {
        assertEquals(7, tobogganOnExample.howManyTreesMet(Point(3, 1)))
        assertEquals(169, Toboggan(InputLoader.loadInput("slopeInput")).howManyTreesMet(Point(3, 1)))
    }

    @Test
    internal fun `count cumulative trees met during several descent`() {
        val slope1 = Point(1, 1)
        val slope2 = Point(3, 1)
        val slope3 = Point(5, 1)
        val slope4 = Point(7, 1)
        val slope5 = Point(1, 2)

        assertEquals(2, tobogganOnExample.howManyTreesMet(slope1))
        assertEquals(7, tobogganOnExample.howManyTreesMet(slope2))
        assertEquals(3, tobogganOnExample.howManyTreesMet(slope3))
        assertEquals(4, tobogganOnExample.howManyTreesMet(slope4))
        assertEquals(2, tobogganOnExample.howManyTreesMet(slope5))
        assertEquals(
            336,
            tobogganOnExample.howManyTreesMetForManySlopes(listOf(slope1, slope2, slope3, slope4, slope5))
        )
        assertEquals(
            7560370818,
            Toboggan(InputLoader.loadInput("slopeInput")).howManyTreesMetForManySlopes(
                listOf(slope1, slope2, slope3, slope4, slope5)
            )
        )
    }

    data class Point(val x: Int, val y: Int) {
        operator fun plus(point: Point) = Point(x + point.x, y + point.y)
    }

    class Toboggan(private val map: List<String>) {
        private val mapWidth = map[0].length
        private val mapHeight = map.size

        fun howManyTreesMetForManySlopes(slopes: List<Point>): Long =
            slopes.fold(1.toLong()) { acc, point -> acc * howManyTreesMet(point) }

        fun howManyTreesMet(move: Point): Int =
            howManyTreesMet(Point(0, 0) + move, move)

        private fun howManyTreesMet(position: Point, move: Point): Int =
            if (position.y > mapHeight - 1)
                0
            else
                inATree(position) + howManyTreesMet(position + move, move)

        private fun inATree(position: Point): Int =
            if (map[position.y][position.x % mapWidth] == TREE)
                1
            else
                0

    }

}

const val mapExample = "..##.......\n" +
        "#...#...#..\n" +
        ".#....#..#.\n" +
        "..#.#...#.#\n" +
        ".#...##..#.\n" +
        "..#.##.....\n" +
        ".#.#.#....#\n" +
        ".#........#\n" +
        "#.##...#...\n" +
        "#...##....#\n" +
        ".#..#...#.#"
