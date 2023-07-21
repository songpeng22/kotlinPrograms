fun main(args: Array<String>) {
    //function takes one line
    singleLineFunction()
    twoLineFunction()
    threeLineFunction(2)
    //for loop
    println("for loop 1..3:")
    for(i in 1..3) println(i)
    println("for loop 4 until 6:")
    for(i in 4 until 6) println(i)
    println("for loop 9 downTo 7:")
    for(i in 9 downTo 7) println(i)
    println("for loop with step:")
    for(i in 1..10 step 2) println(i)
    println("for loop in array:")
    val array = arrayOf(1,5,3)
    for(i in array) println(i)
    println("for loop in array indices:")
    for(i in array.indices) println(i)
    println("for loop in array size:")
    for(i in 0.. array.size) println(i)
    println("for loop with index:")
    for((index,i) in array.withIndex()) println("index:$index item:$i")

    //
    val options = arrayOf("Rock", "Paper", "Scissors")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)
    printResult(userChoice, gameChoice)
}

fun singleLineFunction() = println("this function takes one line.")
fun twoLineFunction()
    = println("this function takes two line.")
fun threeLineFunction(value:Int){
    require(value >= 0) { "Count must be non-negative, was $value" }
}

fun getGameChoice(optionsParam: Array<String>) =
    optionsParam[(Math.random() * optionsParam.size).toInt()]

fun getUserChoice(optionsParam: Array<String>): String {
    var isValidChoice = false
    var userChoice = ""
    //Loop until the user enters a valid choice
    while (!isValidChoice) {
        //Ask the user for their choice
        print("Please enter one of the following:")
        for (item in optionsParam) print(" $item")
        println(".")
        //Read the user input
        val userInput = readLine()
        //Validate the user input
        if (userInput != null && userInput in optionsParam) {
            isValidChoice = true
            userChoice = userInput
        }
        //If the choice is invalid, inform the user
        if (!isValidChoice) println("You must enter a valid choice.")
    }
    return userChoice
}

fun printResult(userChoice: String, gameChoice: String) {
    val result: String
    //Figure out the result
    if (userChoice == gameChoice) result = "Tie!"
    else if ((userChoice == "Rock" && gameChoice == "Scissors") ||
        (userChoice == "Paper" && gameChoice == "Rock") ||
        (userChoice == "Scissors" && gameChoice == "Paper")) result = "You win!"
    else result = "You lose!"
    //Print the result
    println("You chose $userChoice. I chose $gameChoice. $result")
}