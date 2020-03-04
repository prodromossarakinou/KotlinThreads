package helloKotlinThreads.threads

/*
@author: prodromos sarakinou
 */

import allmodels.hellomodels.SecondConstructorExampleClass


fun main(args: Array<String>) {

    val totalThreads = Runtime.getRuntime().availableProcessors()

    //Here we have initialize a simple array of threads
    val threads = arrayOfNulls<Thread>(totalThreads)

    for (index in 0 until totalThreads) {
        threads[index] = Thread(
            SecondConstructorExampleClass(
                id = index,
                totalThreads = totalThreads - 1
            )
        )
    }

    //For each in kotlin

    threads.forEach { thread ->
        //(?) cause threads array is nullable type of object, and (?) saves ass from error
        //So we need to tell to compiler, that the value isn't null
        thread?.start()
    }

    //One more example of for each
    for (thread in threads) {
        //(?) same as before
        try {
            thread?.join()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    println("Job is done")

}