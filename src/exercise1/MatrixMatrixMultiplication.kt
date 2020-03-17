package exercise1

import allmodels.exercise1models.GlobalVariables
import allmodels.exercise1models.MatrixMatrixMultiplicationClass
import kotlin.random.Random

fun main(args: Array<String>) {
    //we will use the thread no only to make multiplications, but also to create the arrays.
    //we will use only square arrays SomethingXSomething


    val matrixOne = ArrayList<IntArray>()
    val matrixTwo = ArrayList<IntArray>()
    for (indexX in 0 until GlobalVariables.dimensions){
        matrixOne.add(IntArray(GlobalVariables.dimensions){
            Random.nextInt(GlobalVariables.lowRandom,GlobalVariables.highRandom)}
        )
    }

    for (indexX in 0 until GlobalVariables.dimensions){
        matrixTwo.add(IntArray(GlobalVariables.dimensions){
            Random.nextInt(GlobalVariables.lowRandom,GlobalVariables.highRandom)}
        )
    }

    for (indexX in 0 until GlobalVariables.dimensions){
        GlobalVariables.resultsArray.add(IntArray(GlobalVariables.dimensions){ 0 })
    }

    for (indexX in 0 until GlobalVariables.dimensions) {
        for (indexY in 0 until GlobalVariables.dimensions) {
            print("${matrixOne[indexX][indexY]} ")
        }
        print("         ")
        for (indexY in 0 until GlobalVariables.dimensions) {
            print("${matrixTwo[indexX][indexY]} ")
        }
        print("         ")
        for (indexY in 0 until GlobalVariables.dimensions) {
            print("${GlobalVariables.resultsArray[indexX][indexY]} ")
        }
        println()
    }
    println()
    println()

    val threads = ArrayList<MatrixMatrixMultiplicationClass>()

    for (index in 0 until GlobalVariables.dimensions/10){
        val thread = MatrixMatrixMultiplicationClass(
            matrixOne = matrixOne,
            matrixTwo = matrixTwo,
            start = index*10,
            end = (index+1)*10
        )
        threads.add(thread)
        thread.start()
    }

    threads.forEach { thread ->
        thread.join()
    }


    for (indexX in 0 until GlobalVariables.dimensions) {
        for (indexY in 0 until GlobalVariables.dimensions) {
            print("${matrixOne[indexX][indexY]} ")
        }
        print("         ")
        for (indexY in 0 until GlobalVariables.dimensions) {
            print("${matrixTwo[indexX][indexY]} ")
        }
        print("         ")
        for (indexY in 0 until GlobalVariables.dimensions) {
            print("${GlobalVariables.resultsArray[indexX][indexY]} ")
        }
        println()
    }
}