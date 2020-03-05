package sqrt.seqsqrt

import java.lang.NumberFormatException
import kotlin.math.sqrt
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val size: Int
    val table: DoubleArray
    if (args.size != 1) {
        println("Usage: kotlin SeqSqrtArgsRandTime <vector size>")
        exitProcess(1)
    }

    try {
        size = Integer.parseInt(args[0])
    } catch (nfe: NumberFormatException) {
        exitProcess(1)
    }

    if (size <= 0) {
        println("size should be positive integer")
        exitProcess(1)
    }

    table = DoubleArray(size)

    val startTime = System.currentTimeMillis()
    table.forEachIndexed { index, _ ->
        table[index] = index.toDouble()
    }

    table.forEachIndexed { index, item ->
        table[index] = sqrt(item)
    }

    val elapsedTimeMillis = System.currentTimeMillis() - startTime

    println("Time in millis: $elapsedTimeMillis")

}

