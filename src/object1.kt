interface Bucket {
    fun fill()
    fun drainAway()
    fun pourTo(that: Bucket)

    fun getCapacity(): Int
    fun getQuantity(): Int
    fun setQuantity(quantity: Int)
}

fun createBucket(capacity: Int): Bucket = object : Bucket {
    var _quantity: Int = 0

    override fun fill() {
        setQuantity(getCapacity())
    }

    override fun drainAway() {
        setQuantity(0)
    }

    override fun pourTo(that: Bucket) {
        val thatVacuity = that.getCapacity()
        if (getQuantity() <= thatVacuity) {
            that.setQuantity(that.getQuantity() + getQuantity())
            drainAway()
        } else {
            that.fill()
            setQuantity(getQuantity() - thatVacuity)
        }
    }

    override fun getCapacity(): Int = capacity

    override fun getQuantity(): Int = _quantity

    override fun setQuantity(quantity: Int) {
        _quantity = quantity
    }
}

fun main(args: Array<String>) {
    val bucket1 = createBucket(7)
    val bucket2 = createBucket(4)

    bucket1.fill()
    bucket1.pourTo(bucket2)

    println(bucket1.getQuantity())
    println(bucket2.getQuantity())
}