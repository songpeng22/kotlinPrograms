class Outer {
    val x = "This is in the Outer class"
    class Nested {
        val y = "This is in the Nested class"
        fun myFun() = "This is the Nested function"
    }
}

fun main(args: Array<String>) {
    val nested = Outer.Nested()
    println(nested.y)
    println(nested.myFun())
}