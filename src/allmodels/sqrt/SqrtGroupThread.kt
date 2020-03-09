package allmodels.sqrt

import kotlin.math.sqrt
//SqrtGroupThread Class:
//Object with array, rank, total threads number, size of block, total size of array
class SqrtGroupThread(
    private val doubleArray: DoubleArray,
    private val myRank: Int, // 0
    private val numOfThreads: Int, // 8
    private val blockSize: Int, //10
    private val size: Int //800
) : Thread(){

    override fun run() {
        val totalBlockSize = this.blockSize*this.numOfThreads //80
        val iterations = size/totalBlockSize // 8000/80 = 10


        //start iterations
        //each thread will make 80 iterations = 10
        for(index in 0 until iterations){
            val start = (this.myRank * this.blockSize) + (index * totalBlockSize) //0 + 0 = 0
            val stop = start     + this.blockSize // 0 + 10
            //first thread 0-9, 10-19, 20-29, 30-39, 40-49, 50-59, 60-69, 70-79 etc...
            for(jIndex in start until stop){
                println("${this.myRank} $start $stop $jIndex")
                this.doubleArray[jIndex] = sqrt(this.doubleArray[jIndex])
            }
        }
    }
}