import kotlin.math.absoluteValue

fun main() {
    fun part1(input: List<String>): Int {
        val left = mutableListOf<Int>()
        val right = mutableListOf<Int>()
        input.forEach { line ->
            val numbers = line.split("   ")
            left.add(numbers[0].toInt())
            right.add(numbers[1].toInt())
        }
        left.sort()
        right.sort()
        return left.withIndex().sumOf { (index, value) ->
            (left[index] - right[index]).absoluteValue
        }
    }

    fun part2(input: List<String>): Int {
        val left = mutableListOf<Int>()
        val right = mutableMapOf<Int, Int>()
        input.forEach { line ->
            val numbers = line.split("   ")
            left.add(numbers[0].toInt())
            right[numbers[1].toInt()] = right.getOrDefault(numbers[1].toInt(), 0) + 1
        }
        return left.sumOf {
            it * (right[it] ?: 0)
        }
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    val output = part1(testInput)
    output.println()
    check(output == 11)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
