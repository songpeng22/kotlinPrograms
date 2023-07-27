class Dog {
    infix fun bark(x: Int): String {
        //Code to make the Dog bark x times
        println(String.format("bark:%d",x))
        return String.format("bark:%d",x)
    }
}

fun main(args: Array<String>) {
    val result = Dog() bark 6
    println(result)
}