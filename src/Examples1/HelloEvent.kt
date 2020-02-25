package Examples1


fun main(args: Array<String>) {
    val numCores = Runtime.getRuntime().availableProcessors()
    val numThreads = 2 * numCores
    val threads = ArrayList<Thread>()
    for (index in 0 until numThreads) {
        pressAnyKeyToContinue()
        val thread = Thread(Inner(id = index))
        thread.start()
        threads.add(thread)
    }

    threads.forEach { thread ->
        pressAnyKeyToContinue()
        thread.interrupt()
        try {
            thread.join()
        }catch (e : InterruptedException){
            e.printStackTrace()
        }
    }

    println("Job is done")

}

fun pressAnyKeyToContinue() {
    println("Press enter to start/stop a thread")
    try {
        readLine()
    }catch (e: Exception){
        e.printStackTrace()
    }
}

class Inner(val id: Int) : Runnable {
    override fun run() {
        while (true) {
            println("***Hello from ${this.id}***")
            try {
                Thread.sleep(5000)
            } catch (e: InterruptedException) {
                println("***Good bye from ${this.id} ***")
                break;
            }
        }

    }
}
