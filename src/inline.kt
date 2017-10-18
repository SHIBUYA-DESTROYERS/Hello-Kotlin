inline fun log(debug: Boolean = true, message: () -> String) {
    if(debug) {
        println(message())
    }
}

fun main(args: Array<String>) {
    log { "このメッセージは出力される" }
    log(false) { "このメッセージは出力されない" }
}