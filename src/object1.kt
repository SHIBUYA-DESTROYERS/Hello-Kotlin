interface Bucket {
    fun fill()
    fun drainAway()
    fun pourTo(that: Bucket)

    fun getCapacity(): Int
    fun getQuantity(): Int
    fun setQuantity(quantity: Int)
}

fun createBucket(capacity: Int): Bucket = object : Bucket {
    val _quantity: Int = 0

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
    val bucket = object: Bucket {
        // バケツの容量
        val capacity: Int = 5

        // はいっている水の量
        var quantity: Int = 0

        // バケツを水で満たす
        fun fill() {
            quantity = capacity
        }

        // 排水する
        fun drainAway() {
            quantity = 0
        }

        // はいっている水の量を出力
        fun printQuantity() {
            println(quantity)
        }

        // 別のバケツに移す
        fun pourTo(that: Bucket) {
            // 未実装
        }
    }

    bucket.printQuantity()
    bucket.fill()
    bucket.printQuantity()
    bucket.drainAway()
    bucket.printQuantity()
}