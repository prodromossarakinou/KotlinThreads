package allmodels.hellomodels
/*
@author: prodromos sarakinou
 */
class MyThreadClass(
    private val id: Int,
    private val totalThreads: Int
) : Thread() {

    override fun run() {
        println("Hello from thread ${this.id} out of ${this.totalThreads}")
        println("Thread ${this.id} exits")
    }

}