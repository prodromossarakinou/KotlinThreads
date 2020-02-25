package Examples1


fun main(args: Array<String>) {
    val numCores = Runtime.getRuntime().availableProcessors()
    val countOfThreads = 2 * numCores
    val threads = ArrayList<Thread>()

    //add threads into the list
    for (index in 0 until countOfThreads) {
        pressAnyKeyToContinue()
        //after key pressed, thread'll be created
        val thread = Thread(Inner(id = index))
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
        }catch (e : InterruptedException){
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
    }catch (e: Exception){
        e.printStackTrace()
    }
}

//Inner runnable class with id
class Inner(private val id: Int) : Runnable {
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
