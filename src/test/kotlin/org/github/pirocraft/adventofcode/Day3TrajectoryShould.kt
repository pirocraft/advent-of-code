package org.github.pirocraft.adventofcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

const val TREE = '#'

class Day3TrajectoryShould {
    @Test
    internal fun `count trees met during descent`() {
        assertEquals(7, Toboggan(mapExample.split("\n")).howManyTreesMet(Point(3, 1)))
        assertEquals(169, Toboggan(InputLoader.loadInput("slopeInput")).howManyTreesMet(Point(3, 1)))
    }

    data class Point(val x: Int, val y: Int) {
        operator fun plus(point: Point) = Point(x + point.x, y + point.y)
    }

    class Toboggan(private val map: List<String>) {
        private val mapWidth = map[0].length
        private val mapHeight = map.size

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

    private val mapExample = "..##.......\n" +
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
}