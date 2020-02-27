package HelloKotlinThreads.models

class EventHello(
    private val id: Int
) : Runnable {

    override fun run() {
        while (true) {
            println("***Hello from ${this.id}***")
            try {
                Thread.sleep(5000)
            } catch (e: InterruptedException) {
                println("***Good bye from ${this.id} ***")
                break;
            }
        }

    }
}