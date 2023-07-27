fun Double.toDollar(): String {
    return "$$this"
}

fun main(args: Array<String>) {
    var dbl = 45.25
    println(dbl.toDollar())
}