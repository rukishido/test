import java.lang.IllegalArgumentException
import kotlin.random.Random

fun main() {
    val mass = generate(5)
    mass.forEachIndexed() { i, array ->
        println("${i + 1} : $array , size : ${array.size}")
    }
}

fun generate(n: Int): List<List<Int>> {
    if (n < 0) throw IllegalArgumentException("N must be positive integer >= 0!")

    val result = mutableListOf<MutableList<Int>>()
    val arraySizes = (1..n * 2).shuffled().take(n)

    for (i in 0 until n) {
        result.add(MutableList(arraySizes[i]) { Random.nextInt(0, n * 100) })
    }

    result.forEachIndexed { i, array ->
        if (i % 2 == 0) {
            array.sort()
        } else {
            array.sortDescending()
        }
    }

    return result
}