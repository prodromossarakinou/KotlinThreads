package helloKotlinThreads.threads

/*
@author: prodromos sarakinou
 */

import allmodels.hellomodels.MyThreadWithDelayClass

fun main(args : Array<String>){

    val numberOfThreads = 10

    val threads = ArrayList<Thread>()

    for (index in 0 until numberOfThreads){
        println("In Main: Create and start thread $index")
        val thread = MyThreadWithDelayClass(index, numberOfThreads)
        thread.start()
        threads.add(index, thread)
    }

    //Wait for threads to finish

    for (thread in threads) {
        try{
            thread.join()
        } catch (e: InterruptedException){
            e.printStackTrace()
        }
    }

    println("In main: threads all done")
}