package sample

fun firstK(str: String): Int {
    fun isK(c: Char): Boolean = c == 'k'
    return first(str, ::isK)
}

fun firstUpperCase(str: String): Int {
    fun isUpperCase(c: Char): Boolean = c.isUpperCase()
    return first(str, ::isUpperCase)
}

fun firstWhitespace(str: String): Int {
    return first(str) { it.isWhitespace() }
}

fun first(str: String, predicate: (Char) -> Boolean): Int {
    tailrec fun go(str: String, index: Int): Int =
            when {
                str.isEmpty() -> -1
                predicate(str.first()) -> index
                else -> go(str.drop(1), index + 1)
            }
    return go(str, 0)
}

fun main(args: Array<String>) {
    val sentence: String = "i am Ryosuke Hagiahra"
    // val first = ::firstK
    // val first = ::firstUpperCase
    val first = ::firstWhitespace

    println(first(sentence))
}