package allmodels.sqrt

import kotlin.math.sqrt

class SqrtThread(
    private var doubleArray: DoubleArray,
    private val index: Int
): Thread(){

    override fun run() {
        doubleArray[index] = sqrt(doubleArray[index])
    }

}