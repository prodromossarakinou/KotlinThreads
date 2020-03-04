package allmodels.countermodels
/*
@author: prodromos sarakinou
 */

/*
Example with
default values in constructor
 */

class CounterJoinClass(
    private var count: Int,
    private val inc : Int = 1,
    private val delay : Int
) : Thread() {
    override fun run(){
        for(i in 0 until 100){
            println("Count: ${this.count}")
            count += inc
            sleep(delay.toLong())
        }
    }

}