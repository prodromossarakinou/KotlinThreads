package exercise1

import allmodels.exercise1models.GlobalVariables
import allmodels.exercise1models.MatrixVectorMultiplicationClass
import kotlin.random.Random

fun main(args: Array<String>) {
    val array = ArrayList<IntArray>()
    val dimensions = 100
    val threadsCount = dimensions/10
    val vector = IntArray(dimensions) {
        Random.nextInt(
            GlobalVariables.lowRandom,
            GlobalVariables.highRandom
        )
    }
    GlobalVariables.resultsVector = IntArray(dimensions)

    for (indexX in 0 until dimensions) {
        array.add(IntArray(dimensions) {
            Random.nextInt(
                GlobalVariables.lowRandom,
                GlobalVariables.highRandom
            )
        })
    }



    val threads = ArrayList<MatrixVectorMultiplicationClass>()
    for (index in 0 until threadsCount) {
        val thread = MatrixVectorMultiplicationClass(
            start = index * 10,
            end = (index + 1) * 10,
            matrix = array,
            vector = vector
        )
        threads.add(thread)
        thread.start()
    }

    threads.forEach {
        it.join()
    }

    for (indexX in 0 until dimensions) {
        array[indexX].forEach {
            print("$it ")
        }
        print("         ")
        print("${vector[indexX]}")

        print("         ")
        print("${GlobalVariables.resultsVector[indexX]}")

        println()
    }


}