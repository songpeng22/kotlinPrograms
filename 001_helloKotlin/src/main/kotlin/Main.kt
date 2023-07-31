fun main(args: Array<String>) {
    //define variable
    var x = 1
    //print variable
    println("hello kotlin in IntelliJ IDEA.")
    println("x = $x.")

    //when
    var alignmentIn:Int = 1
    var alignment:String = when(alignmentIn){
        1 -> "left"
        2 -> "center"
        4 -> "right"
        else -> "null"
    }
    println("alignment:${alignment}")
}