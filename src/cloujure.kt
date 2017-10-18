package sample

fun getCounter(): () -> Int {
    var count = 0
    return {
        count++
    }
}

fun main(args: Array<String>) {
    val counter1 = getCounter()
    val counter2 = getCounter()
    println(counter1())
    println(counter1())
    println(counter2())
    println(counter1())
    println(counter2())
}