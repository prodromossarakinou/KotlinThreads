package counters
/*
@author: prodromos sarakinou
 */

import allmodels.countermodels.CounterIntrClass
import java.lang.Thread.sleep

fun main(args: Array<String>){
    val first = initializeThread(
        0,
        1,
        87
    )
    val second = initializeThread(
        0,
        -1 ,
        100
    )
    first.start()
    second.start()


    try{
        sleep(1000)
        println("Main wakes up to kill first thread")
    }catch (e: InterruptedException){
        e.printStackTrace()
    }
    first.interrupt()

    try{
        sleep(2000)
        println("Main wakes up to kill second thread")
    } catch (e: InterruptedException){
        e.printStackTrace()
    }
    second.interrupt()



    println("\n\n\nBye now")

}

fun initializeThread(
    count: Int,
    inc: Int,
    delay: Int
) : CounterIntrClass {
    return CounterIntrClass(count, inc, delay)
}