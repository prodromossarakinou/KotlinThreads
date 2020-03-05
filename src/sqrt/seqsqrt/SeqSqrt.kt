package sqrt.seqsqrt

import kotlin.math.sqrt

fun main(args : Array<String>){

    val table = DoubleArray(1000)

    table.forEachIndexed { index, _ ->
        table[index] = index.toDouble()
    }

    table.forEachIndexed { index, item ->
        table[index] = sqrt(item)
    }

    table.forEach{ item ->
        println(item)
    }

}