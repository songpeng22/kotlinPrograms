fun main(args: Array<String>) {
    //when class instantiate, class constructor is called to construct class
    val myDog = Dog("Fido", 70, "Mixed")
    myDog.bark()
    myDog.weight = 75
    println("Weight in Kgs is ${myDog.weightInKgs}")

    myDog.weight = -2
    println("Weight is ${myDog.weight}")

    myDog.activities = arrayOf("Walks", "Fetching balls", "Frisbee")
    for (item in myDog.activities) {
        println("My dog enjoys $item")
    }
    //array of class object
    val dogs = arrayOf(Dog("Kelpie", 20, "Westie"), Dog("Ripper", 10, "Poodle"))
    dogs[1].bark()
    dogs[1].weight = 15
    println("Weight for ${dogs[1].name} is ${dogs[1].weight}")

    //when class instantiate, class constructor is called to construct class
    val test = Test(-1)
    //define simple java field, do not have getter setter
    //makes static final variable
//    public class Sample {
//        public static final int MAX_LIMIT = 20;
//    }
//    inner class Sample {
//        companion object {
//            @JvmField val MAX_LIMIT = 20
//        }
//    }
}