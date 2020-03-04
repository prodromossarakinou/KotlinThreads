package helloKotlinThreads.threads

/*
@author: prodromos sarakinou
 */

import allmodels.hellomodels.MyRunnableClass

const val numberOfThreads = 12
fun main(args: Array<String>) {

    //Here we have initialize a simple array of threads
    val threads = arrayOfNulls<Thread>(numberOfThreads)

    for (index in 0 until numberOfThreads) {
        println("In main: create and start thread $index")
        threads[index] = Thread(MyRunnableClass(index, numberOfThreads))
        //We have add a value into threads[index], so we know that now isn't null
        //We use double exclamation mark, cause in other case program never compiled
        threads[index]!!.start()
    }
}