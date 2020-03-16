package allmodels.sqrt.SPMDCyclicSingle

import kotlin.math.sqrt


class SPMDCSqrtGroupThread(
    private val doubleArray: DoubleArray,
    private val myRank: Int,
    private val numberOfThreads: Int,
    private val mySize: Int
) : Thread() {

    override fun run() {

        var index: Int = this.myRank
        while (index < this.mySize) {
            this.doubleArray[index] = sqrt(this.doubleArray[index])
            index += numberOfThreads
        }

    }

}