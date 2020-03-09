package allmodels.examples

object GlobalVariables {

    const val iterations = 8000
    const val totalThreads = 16
    var randomNumbersList = ArrayList<Int>()
    fun createList() {
        for (index in 0 until iterations) {
            randomNumbersList.add(index, (Math.random() * 100).toInt())
        }
    }
    fun duplicate(index: Int){
        print("${randomNumbersList[index]} ")
        randomNumbersList[index] = randomNumbersList[index] * 2
        print("${randomNumbersList[index]} ")
    }
}
