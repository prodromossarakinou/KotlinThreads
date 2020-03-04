package helloKotlinThreads.threads

/*
@author: prodromos sarakinou
 */


import allmodels.hellomodels.RecursiveRunnableClass


fun main(args: Array<String>) {
    val numCores = Runtime.getRuntime().availableProcessors()

    val numThreads = 8 * numCores

    println("Starting thread 0")
    val thread = Thread(RecursiveRunnableClass(0, numThreads))
    //Start first thread
    thread.start()
    try {
        //Wait for it to finish.
        thread.join()
    } catch (e: InterruptedException) {
        e.printStackTrace()
    }

    println("Job is done!")
}
