package counters

import allmodels.countermodels.CounterOneClass

fun main(args: Array<String>){

    //this thread will prints: 1 2 3 4 5 6 7 8 9 .....
    val positiveCounter = CounterOneClass(0, 1, 84)
    //this thread will print -1 -2 -3 -4 -5 -6 -7 -8 -9 .....
    val negativeCounter = CounterOneClass(0, -1, 56)
    //Daemon threads will stop after main(parent) thread ends

    //ENABLE DAEMON OF THEM
    positiveCounter.isDaemon = true
    negativeCounter.isDaemon = true

    //START THEM
    positiveCounter.start()
    negativeCounter.start()

    try{
        Thread.sleep(10000)
    }catch (e: InterruptedException){
        e.printStackTrace()
    }

}