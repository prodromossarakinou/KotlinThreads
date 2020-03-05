package exampleThreads

import allmodels.examples.GlobalVariables

object DuplicateExampleWithoutThreads{
    fun duplicateExampleWithoutThreads(){
        val starTime = System.currentTimeMillis()

        GlobalVariables.randomNumbersList.forEachIndexed { index, _ ->
            GlobalVariables.duplicate(index)
        }
        println()
        println("DUPLICATE WITHOUT THREADS: TOTAL TIME: ${System.currentTimeMillis() - starTime}")
    }
}