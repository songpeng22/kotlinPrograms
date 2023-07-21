fun Any.getType(): String {
    when (this::class.simpleName.toString()) {
        "Int" -> return "Int"
        "Long" -> return "Long"
        "Float" -> return "Float"
        "Double" -> return "Double"
        "String" -> return "String"
        else -> return "UNKNOWN"
    }
    return "UNKNOWN"
}
fun main(args: Array<String>) {
    /*
     * arrayOf and listOf is immutable
     * mutableArrayOf and mutableListOf is mutalbe
     * */
    /*
     * print variable
     * */
    //print variable
    var a = 1
    println("a is:${a}")
    //explicityly define a variable's type
    var b:Int = 2
    println("b is:${b}")
    //convert value in order to assign it to another variable type
    var c = 5
    var d: Long = c.toLong()
    println("d is:${d}")
    //print array
    var array = arrayOf(1,2,3)
    //print array - comprise a string to print
    println("numArray is ${array[0]} ${array[1]} ${array[2]}")
    //print Class::function
    println("numArray.size is ${array.size}")
    //test
    //Math.random() -> Returns a double value greater than or equal to 0.0 and less than 1.0.
    val rand1 = Math.random()
    println("random value is:${rand1}")
    var testArray = arrayOf(1,2,3)
    var cal = (rand1 * testArray.size).toInt()
    println("cal is:${cal}")
    //get type
    when (rand1::class.simpleName) {
        "Double" -> println("Inferred type is Double")
        "Float" -> println("Inferred type is Float")
        "Int" -> println("Inferred type is Int")
        else -> { // Note the block
            println("it's neither Float nor Double nor Int")
        }
    }
    println("rand1.getType:${rand1.getType()}")
    println("(rand1 * testArray.size).getType:${(rand1 * testArray.size).getType()}")
    /*
     * Array
     * */
    //Array do not have add
    //define a array
    var numArray = arrayOf(1,2,3)
    var strArray = arrayOf("a","bb","ccc")
    //print
    println(numArray[0])
    println(strArray[0])
    println("strArray is ${strArray[0]} ${strArray[1]} ${strArray[2]}")
    //Array::set()
    strArray.set(2,"dddd")
    //Array::get()
    println("strArray is ${strArray[0]} ${strArray[1]} ${strArray.get(2)}")
    //Array::loop
    strArray.forEach { println(it) }
    //explicityly define a variable's type
    var exArray: Array<Byte> = arrayOf(1, 2, 3)
    println("exArray is ${exArray[0]} ${exArray[1]} ${exArray[2]}")

    /*
    * List
    * */
    //define a list
    var strList = listOf<String>()
    strList = listOf("a","b","c")
    println("strList is ${strList[0]} ${strList[1]} ${strList[2]}")
    //list is immutable list, can not add
    //mutable list
    var mutableList:MutableList<String> =  mutableListOf("a","b","c")
    //mutalbe list -> can add
    mutableList.add("d")
    mutableList.forEach{
        println(it)
    }

}