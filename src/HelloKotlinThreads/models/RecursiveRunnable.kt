package HelloKotlinThreads.models

class RecursiveRunnable(
    private val id: Int,
    private val limit: Int
) : Runnable {

    override fun run() {
        println(" *** Hello from ${this.id} ***")
        //Sleep this thread and continue
        try{
            //instead of sleep, we can make some difficult calculations
            Thread.sleep(1000)
        }catch (e: InterruptedException){
            e.printStackTrace()
        }

        if(this.id == limit){
            println("***Goodbye from ${this.id}***")
        }else{
            //Start the next thread, until threads == limit
            println("Starting thread ${this.id + 1}...")
            val thread = Thread(RecursiveRunnable(this.id + 1, this.limit))
            thread.start()

            try{
                //wait for it to finish
                thread.join()
            }catch (e: InterruptedException){
                e.printStackTrace()
            }

            //the next thread finished
            println(" Thread ${this.id + 1} is finished");

            try {
                Thread.sleep(1000)
            }catch (e: InterruptedException){
                e.printStackTrace()
            }

            println("***Goodbye from ${this.id}***")
        }

    }


}