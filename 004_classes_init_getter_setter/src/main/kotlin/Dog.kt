class Dog(val name: String,     //define property -> generate getter and setter
          weight_param: Int,    //plain old parameter -> immutable, can't reassign a value
          breed_param: String) {//plain old parameter -> immutable, can't reassign a value
    init {
        print("init: ") //print do not generate a new line.
        println("Dog $name has been created. ")
    }

    var activities = arrayOf("Walks")
    val breed = breed_param.toUpperCase()
    init {
        println("The breed is $breed.")
    }

    var weight = weight_param
        set(value) {
            println("weight is being set:")
            if (value > 0) field = value
        }
    val weightInKgs: Double
        get() = weight / 2.2

    fun bark() {
        println(if (weight < 20) "Yip!" else "Woof!")
    }
}

class Test{
    constructor(value:Int){
        require(value >= 0) { "Count must be non-negative, was $value" }
        println("test::constructor() is called")
    }
}