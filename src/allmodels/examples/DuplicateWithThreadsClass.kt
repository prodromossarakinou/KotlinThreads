package allmodels.examples

class DuplicateWithThreadsClass (
    private val start: Int,
    private val end: Int
) : Thread() {
    override fun run() {
        for(index in start until end){
            GlobalVariables.duplicate(index)
         }
    }
}