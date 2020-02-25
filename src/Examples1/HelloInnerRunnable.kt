package Examples1

const val numThreads = 10
fun main(args : Array<String>){
    val threads = ArrayList<Thread>()

    for(index in 0 until numThreads){
        println("In main: starting thread: $index")
        val t = Thread(InnerClass(index))
        threads.add(t)
        t.start()

    }
    //Stop them

    threads.forEach { thread ->
        try{
            thread.join()
        }catch (e: InterruptedException){
            e.printStackTrace()
        }
    }
}

class InnerClass(val id: Int) : Runnable{
    override fun run() {
        println("Hello from ${this.id} of $numThreads")
    }

}