package sqrt.sqrtThread

import allmodels.sqrt.SqrtThread
import java.lang.NumberFormatException
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val size : Int
    val table: DoubleArray
    if (args.size != 1) {
        println("Usage: kotlin ParSqrtArgsRandTime <vector size>")
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

    val threads = ArrayList<SqrtThread>()

    for (index in 0 until size) {
        threads.add(index,SqrtThread(table, index) )
        threads[index].start()
    }

    threads.forEach { thread ->

        try{
            thread.join()
        }catch (e : InterruptedException){
            e.printStackTrace()
        }


    }
    val elapsedTimeMillis = System.currentTimeMillis() - startTime

    println("Time in millis: $elapsedTimeMillis")

}