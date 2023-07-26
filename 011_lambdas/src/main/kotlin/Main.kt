typealias DoubleConversion = (Double) -> Double

//function accept lambdas as parameter
fun convert(x: Double,
            converter: (Double) -> Double) : Double {
    val result = converter(x)
    println("$x is converted to $result")
    return result
}

//function accept lambdas as parameter
fun convertFive(converter: (Int) -> Double) : Double {
    val result = converter(5)
    println("5 is converted to $result")
    return result
}

//function return lambdas
fun getConversionLambda(str: String): DoubleConversion {
    if (str == "CentigradeToFahrenheit") {
        return { it * 1.8 + 32 }
    } else if (str == "KgsToPounds") {
        return { it * 2.204623 }
    } else if (str == "PoundsToUSTons") {
        return { it / 2000.0 }
    } else {
        return { it }
    }
}
fun combine(lambda1: DoubleConversion,
            lambda2: DoubleConversion): DoubleConversion {
    return { x: Double -> lambda2(lambda1(x)) }
}

//

fun main(args: Array<String>) {
    /*
     * pass lambdas to variable
     */
    //short invoke: addFive(6)
    var addFive = { x: Int -> x + 5 }
    println("Pass 6 to addFive: ${addFive(6)}")

    //explicitly invoke
    val addInts = { x: Int, y: Int -> x + y }
    val result = addInts.invoke(6, 7)
    println("Pass 6, 7 to addInts: $result")

    /*
     * assign a lambdas to a lambdas
     */
    //define a lambdas variables and assign it a reference to lambdas
    val intLambda: (Int, Int) -> Int = { x, y -> x * y }
    println("Pass 10, 11 to intLambda: ${intLambda(10, 11)}")

    //use it, if only one parameter is available
    val addSeven: (Int) -> Int = { it + 7 }
    println("Pass 12 to addSeven: ${addSeven(12)}")

    //no return value
    val myLambda: () -> Unit = { println("Hi!") }
    myLambda()

    /*
     * pass lambdas to function
     * note: must pass data and lambdas together to function
     * */
    //use lambdas as parameter
    convert(20.0, { it * 1.8 + 32 }) //move lambdas outside (), if parameter is lambdas
    convert(20.0) { it * 1.8 + 32 }
    //use lambdas as parameter
    convertFive() { it * 1.8 + 32 }     //if parameter is a single lambdas, () could be removed
    convertFive { it * 1.8 + 32 }

    /*
     * return lambdas from function
     * */
    //use returned lambdas to calculate
    //Convert 2.5kg to Pounds
    println("Convert 2.5kg to Pounds: ${getConversionLambda("KgsToPounds")(2.5)}")

    //Define two conversion lambdas
    val kgsToPoundsLambda = getConversionLambda("KgsToPounds")
    val poundsToUSTonsLambda = getConversionLambda("PoundsToUSTons")

    /*
     * combined lambdas
     * */
    //Combine the two lambdas to create a new one
    val kgsToUSTonsLambda = combine(kgsToPoundsLambda, poundsToUSTonsLambda)
    //Use the new lambda to convert 17.4 to US tons
    val value = 17.4
    println("$value kgs is ${convert(value, kgsToUSTonsLambda)} US tons")

    /*
     * DIY
     * */
    //pass lambdas to val
    //define lambdas and invoke elsewhere
    val d:Double = CalConcrete.calConcrete(1,"2")
    println("d is $d.")
    //pass lambdas to function
    CalConcrete.funConcrete(1,"2",CalDefine.cal)
}