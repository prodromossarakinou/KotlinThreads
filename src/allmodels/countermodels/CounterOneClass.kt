package allmodels.countermodels

class CounterOneClass(
    private val startedValue: Int,
    private val increase: Int,
    private val delay: Int
) : Thread() {
    override fun run() {
        var value = startedValue
        while (true) {
            println("COUNT $value")
            value += this.increase
            sleep(delay.toLong())
        }
    }

}

