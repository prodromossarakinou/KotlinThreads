package exampleThreads

import allmodels.examples.GlobalVariables

fun main(args : Array<String>){
    GlobalVariables.createList()
    println("Non threads example started")
    DuplicateExampleWithoutThreads.duplicateExampleWithoutThreads()

    println("Threads example started")
    DuplicateExampleWithThreads.duplicateExampleWithThreads()



}
