package Examples1

//global variable countOfThreads
const val countOfThreads = 10

fun main(args : Array<String>){

    val threads = ArrayList<Thread>()

    //fill list with threads
    for(index in 0 until countOfThreads){
        println("In main: starting thread: $index")
        val thread = Thread(InnerClass(index))
        //start thread
        threads.add(thread)
        thread.start()

    }
    val w = Worker()

    //Then, stop them
    threads.forEach { thread ->
        try{
            thread.join()
        }catch (e: InterruptedException){
            e.printStackTrace()
        }
    }
}

class InnerClass(private val id: Int) : Runnable{
    override fun run() {
        println("Hello from ${this.id} of $countOfThreads")
    }

}