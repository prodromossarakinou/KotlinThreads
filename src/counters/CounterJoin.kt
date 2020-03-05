package counters

import allmodels.countermodels.CounterJoinClass
import java.lang.Exception

/*
@author: prodromos sarakinou
 */

fun main(args: Array<String>?){
    val counter1 = CounterJoinClass(
        count = 0,
        delay = 93
    )
    val counter2 = CounterJoinClass(
        count = 0,
        inc = -1,
        delay = 100
    )

    println("Threads starting")
    counter1.start()
    counter2.start()



    try{
        println("counter1 joins")
        counter1.join()
        println("counter2 joins")
        counter2.join()

    }catch (e: Exception){
        e.printStackTrace()
    }

    println("main exiting")
}