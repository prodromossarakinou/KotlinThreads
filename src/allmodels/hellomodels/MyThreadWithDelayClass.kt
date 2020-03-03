package allmodels.hellomodels

class MyThreadWithDelayClass (
    private val id: Int,
    private val totalThreads: Int
) : Thread() {
    override fun run() {
        randomDelay()
        println("Hello from thread ${this.id} out of ${this.totalThreads}")
        randomDelay()
        println("Thread: ${this.id} exits")
    }

    fun randomDelay(){
        val scale = 1000
        try{
            sleep((Math.random()*scale).toInt().toLong())
        } catch (e : InterruptedException) {
            e.printStackTrace()
        }
    }
}