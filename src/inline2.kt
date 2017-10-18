inline fun forEach(str: String, f: (Char) -> Unit) {
    for (c in str) {
        f(c)
    }
}

fun containsDigit(str: String): Boolean {
    var result = false
    forEach(str) {
        if (it.isDigit()) {
            result = true
            return@forEach
        }
    }
    return result
}

fun main(args: Array<String>) {
    val str: String = "Hag1hara Ryosuke"
    println(containsDigit(str))
}