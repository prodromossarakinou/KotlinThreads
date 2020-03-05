package sqrt.sqrtThread

import allmodels.sqrt.SqrtGroupThread
import java.lang.NumberFormatException
import kotlin.system.exitProcess

fun main(args : Array<String>){
    val size : Int
    val numberOfThreads : Int
    val blockSize : Int
    val doubleArray : DoubleArray
    if(args.size!=3){
        println("Usage: kotlin ParSqrtArgsRandTime <vector size> <block size> <number of threads>")
        exitProcess(1)
    }

    try{
        size = Integer.parseInt(args[0])
        numberOfThreads = if(Integer.parseInt(args[1]) == 0) Runtime.getRuntime().availableProcessors() else Integer.parseInt(args[1])
        blockSize = Integer.parseInt(args[2])
    }catch (nfe : NumberFormatException){
        println("Integer args expected")
        exitProcess(1)
    }
    if(size % (blockSize * numberOfThreads ) != 0){
        println("Attention: <vector size> % (<block size>*<number of threads>) should be 0")
        exitProcess(0)
    }

    doubleArray = DoubleArray(size)

    for( index in 0 until size){
        doubleArray[index] = index.toDouble()
    }

    val startTime = System.currentTimeMillis()
    val threads : ArrayList<SqrtGroupThread> = ArrayList()

    for (index in 0 until numberOfThreads){
        threads.add(index, SqrtGroupThread(
            doubleArray = doubleArray,
            myRank = index,
            numOfThreads = numberOfThreads,
            blockSize = blockSize,
            size =size
        ))
        threads[index].start()
    }

    threads.forEach {
        try{
            it.join()
        } catch (e : InterruptedException){
            e.printStackTrace()
        }
    }

    val elapsedTimeMillis = System.currentTimeMillis() - startTime

    println("Time in millis: $elapsedTimeMillis")

}