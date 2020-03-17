package allmodels.exercise1models

class MatrixMatrixMultiplicationClass(
    private val start: Int,
    private val end: Int,
    private val matrixOne: ArrayList<IntArray>,
    private val matrixTwo: ArrayList<IntArray>
) : Thread() {


    override fun run() {
        for (indexX in start until end) {

            for (indexY in 0 until GlobalVariables.dimensions) {
                var lineResult = 0
                matrixTwo[indexX].forEach {
                    lineResult += matrixOne[indexX][indexY]*it
                }
                GlobalVariables.resultsArray[indexX][indexY] = lineResult
            }

        }
    }
}