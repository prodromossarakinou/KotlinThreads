package allmodels.hellomodels
/*
@author: prodromos sarakinou
 */
class MyRunnableClass(
    private val id: Int,
    private val totalThreads: Int
) : Runnable {
    //Simple thread, Hello and exit
    override fun run() {
        println("Hello from thread ${this.id} out of ${this.totalThreads}")
        println("Thread ${this.id} exits")
    }
}