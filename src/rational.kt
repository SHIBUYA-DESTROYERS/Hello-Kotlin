class Rational(n: Int, d: Int) {
    init {
        require(d != 0, {"denominator must not be null"})
    }
    private val g by lazy { gcd(Math.abs(n), Math.abs(d)) }
    val numerator: Int by lazy { n / g }
    val denominator: Int by lazy { d / g }
    operator fun plus(that: Rational): Rational =
            Rational(
                    numerator * that.denominator + that.numerator * denominator,
                    denominator * that.denominator
            )
    operator fun plus(n: Int): Rational =
            Rational(numerator + n * denominator, denominator)
    override fun toString(): String = "${numerator}/${denominator}"
    tailrec private fun gcd(a: Int, b: Int): Int =
            if (b == 0) a
            else gcd(b, a % b)
}

operator fun Int.plus(r: Rational): Rational = r + this

fun main(args: Array<String>) {
    println(3 + Rational(1, 4))
}