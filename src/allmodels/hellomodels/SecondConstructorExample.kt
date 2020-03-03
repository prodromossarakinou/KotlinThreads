package allmodels.hellomodels
/*
    This is an example about:
        1. Kotlin secondary constructor
        2. Null Safety

*/

class SecondConstructorExample() : Runnable {
    // ? after Int, say to compiler, that the var could be Int or null -> Kotlin's null safety
    // We can use ? after any type of variable
    private var id: Int? = null
    private var totalThreads: Int? = null

    constructor(id: Int?, totalThreads: Int?) : this() {
        this.id = id
        this.totalThreads = totalThreads
    }

    //KOTLIN'S NULL SAFETY EXAMPLES
    override fun run() {
        // Total threads = 10, if totalThread = null, else totalThreads = totalThreads
        this.totalThreads = this.totalThreads ?: 10
        id?.let {
            println("Hello from $it of ${this.totalThreads}")
        } ?: run {
            println("Error with this thread: NULL VALUES")
        }
    }
}