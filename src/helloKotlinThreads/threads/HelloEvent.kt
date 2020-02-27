package helloKotlinThreads.threads

import helloKotlinThreads.models.EventHello


fun main(args: Array<String>) {
    val numCores = Runtime.getRuntime().availableProcessors()
    val countOfThreads = 2 * numCores
    val threads = ArrayList<Thread>()

    //add threads into the list
    for (index in 0 until countOfThreads) {
        pressAnyKeyToContinue()
        //after key pressed, thread'll be created
        val thread = Thread(EventHello(id = index))
        //start them
        thread.start()
        threads.add(thread)
    }

    threads.forEach { thread ->
        pressAnyKeyToContinue()
        //after key pressed, thread'll be interrupted
        thread.interrupt()
        try {
            thread.join()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    println("Job is done")

}

fun pressAnyKeyToContinue() {
    println("Press enter to start/stop a thread")
    try {
        //read line from sytem in
        readLine()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}
