fun main(args: Array<String>) {
    //nullable String vs String -> convert nullable to normal
    val nullableString:String? = "not null"
    val normalString:String = nullableString ?: "null"
    println(normalString)

    //judge null with if
    var w: Wolf? = Wolf()
    if (w != null) {
        w.eat()
    }
    //judge null with ?
    var x = w?.hunger
    println("The value of x is $x")

    //if w is null null and hunger is not null return hunger, else return -1
    var y = w?.hunger ?: -1
    println("The value of y is $y")

    var myWolf = MyWolf()
    myWolf?.wolf?.hunger = 8
    println("The value of myWolf?.wolf?.hunger is ${myWolf?.wolf?.hunger}")

    var myArray = arrayOf("Hi", "Hello", null)
    for (item in myArray) {
        item?.let { println(it) }
    }
    //shorter usage
    getAlphaWolf()?.let { it.eat() }

    try{
        //w = null
        var z = w!!.hunger//suppose to throw NullPointerException, but the compiler not allowed actually.
    }
    catch (e: Exception){
        e.printStackTrace()
    }
    finally {
        //clean up
    }

}