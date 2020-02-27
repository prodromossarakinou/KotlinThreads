package helloKotlinThreads.threads

fun main(args: Array<String>) {
    val countOfThreads = Runtime.getRuntime().availableProcessors()

    //Create table with threads

    val threads = Array(countOfThreads) { _ ->
        Thread {
            println("Hello world from ${Thread.currentThread().name}")
        }
    }

    println("Starting threads")


    //Start them up
    threads.forEach {thread ->
        thread.start()
    }

    //wait them for finish
    threads.forEach {thread ->
        try {
            thread.join()
        } catch (e: InterruptedException) {
            println("This should not happen ${e.stackTrace}")
        }
    }

    println("Job is done")
}


