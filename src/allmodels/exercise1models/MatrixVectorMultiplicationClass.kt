package allmodels.exercise1models

class MatrixVectorMultiplicationClass(
    private val start: Int,
    private val end: Int,
    private val matrix : ArrayList<IntArray>,
    private val vector : IntArray
) : Thread() {


    override fun run() {

        for ( (index,m) in matrix.withIndex()){
            var lineResult = 0
            for((counter, a) in m.withIndex()){
                lineResult += vector[counter] * a

            }
            GlobalVariables.resultsVector[index] = lineResult
        }
    }
}

