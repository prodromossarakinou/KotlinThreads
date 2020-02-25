class Person (
    private val name: String,
    private val age: Int,
    private val email: String
    ){

    override fun toString(): String {
        return "Name: ${this.name} Age: ${this.age} Email: ${this.email}"
    }
}