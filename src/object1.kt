interface Bucket {
    fun fill()
    fun drainAway()
    fun pourTo(that: Bucket)

    val capacity: Int
    var quantity: Int
}

fun createBucket(_capacity: Int): Bucket = object : Bucket {

    override val capacity = _capacity

    override var quantity: Int = 0

    override fun fill() {
        quantity = capacity
    }

    override fun drainAway() {
        quantity = 0
    }

    override fun pourTo(that: Bucket) {
        val thatVacuity = that.capacity - that.quantity
        if (capacity <= thatVacuity) {
            that.quantity += quantity
            drainAway()
        } else {
            that.fill()
            quantity -= thatVacuity
        }
    }
}

fun main(args: Array<String>) {
    val bucket1 = createBucket(7)
    val bucket2 = createBucket(4)

    bucket1.fill()
    bucket1.pourTo(bucket2)

    println(bucket1.quantity)
    println(bucket2.quantity)
}