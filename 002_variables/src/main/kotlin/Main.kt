fun main(args: Array<String>) {
    //define a array
    var numArray = arrayOf(1,2,3)
    var strArray = arrayOf("a","bb","ccc")
    //print
    println(numArray[0])
    println(strArray[0])

    val size = numArray.size
    //print a variable
    println("numArray.size is $size")
    println("numArray.size is ${numArray.size}")
    //comprise a string to print
    println("numArray is ${numArray[0]} ${numArray[1]} ${numArray[2]}")

    //explicityly define
    var exArray: Array<Byte> = arrayOf(1, 2, 3)
    println("exArray is ${exArray[0]} ${exArray[1]} ${exArray[2]}")
}