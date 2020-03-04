package allmodels.countermodels
/*
@author: prodromos sarakinou
 */

class CounterIntrClass (
    private var count: Int,
    private val inc: Int,
    private val delay: Int
) : Thread() {

    override fun run() {
        while(true){
            count += inc
            println("Count ${this.count}")
            try{
                sleep(delay.toLong())
            }catch (e: InterruptedException){
                println("Sorry, I was interrupted")
                break;
            }
        }
    }

}