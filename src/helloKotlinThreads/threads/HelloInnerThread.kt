package helloKotlinThreads.threads

const val numThreads = 10

fun main(args: Array<String>) {
    val threads: ArrayList<Thread> = ArrayList()

    for (numberOfThread in 0 until numThreads) {
        println("In main: starting thread $numberOfThread")
        val thread = InnerThread(numberOfThread)
        threads.add(numberOfThread, thread)
        thread.start()
    }


    threads.forEach { thread ->
        try {
            thread.join()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    println("In main: threads all done")

}

class InnerThread(private val id: Int) : Thread() {

    override fun run() {
        println("Hello from ${this.id} of $numThreads")
    }


}