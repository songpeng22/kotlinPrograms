fun main(args: Array<String>) {
    val r1 = Recipe("Thai Curry", "Chicken", false)
    val r2 = Recipe(title = "Thai Curry", mainIngredient = "Chicken", false)
    val r3 = r1.copy(title = "Chicken Bhuna")
    val r4 = Recipe(mainIngredient="beef")

    println("r1 hash code: ${r1.hashCode()}")
    println("r2 hash code: ${r2.hashCode()}")
    println("r3 hash code: ${r3.hashCode()}")
    println("r4 hash code: ${r4.hashCode()}")

    println("r1 toString: ${r1.toString()}")
    println("r4 toString: ${r4.toString()}")

    println("r1 == r2? ${r1 == r2}")    //r1 == r2 is true because their objects have matching values.
    println("r1 === r2? ${r1 === r2}")  //As they refer to separate objects, r1 === r2 is false.
    println("r1 == r3? ${r1 == r3}")

    //define multiple variables and assign values according constructor property sequence
    val (title, mainIngredient, vegetarian, difficulty) = r1
    println("title is $title and vegetarian is $vegetarian")

    val m1 = Mushroom(6, false)
    println("m1 size is ${m1.size} and isMagic is ${m1.isMagic}")
    val m2 = Mushroom(true)
    println("m2 size is ${m2.size} and isMagic is ${m2.isMagic}")
    //
    println(addNumbers(2, 5))
    println(addNumbers(1.6, 7.3))
}