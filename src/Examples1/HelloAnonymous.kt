package Examples1

fun main(args: Array<String>) {
    val numThreads = Runtime.getRuntime().availableProcessors()


    val threads = Array(numThreads) { _ ->
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


