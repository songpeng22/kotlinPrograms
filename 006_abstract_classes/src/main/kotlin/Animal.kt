interface Roamable {
    fun roam()
}

abstract open class Animal : Roamable {
    abstract open val image: String
    abstract open val food: String
    abstract open val habitat: String
    var hunger = 10

    abstract open fun makeNoise()
    abstract open fun eat()

    override fun roam(){
        println("The Animal is roaming")
    }
    fun sleep() {
        println("The Animal is sleeping")
    }
}

class Hippo : Animal() {
    override val image = "hippo.jpg"
    override val food = "grass"
    override val habitat = "water"
    override fun makeNoise() {
        println("Grunt! Grunt!")
    }
    override fun eat() {
        println("The Hippo is eating $food")
    }
}

abstract class Canine : Animal() {
    override fun roam() {
        println("The Canine is roaming")
    }
}

class Wolf : Canine() {
    override val image = "wolf.jpg"
    override val food = "meat"
    override val habitat = "forests"
    override fun makeNoise() {
        println("Hooooowl!")
    }
    override fun eat() {
        println("The Wolf is eating $food")
    }
}

class Vehicle : Roamable {
    override fun roam() {
        println("The Vehicle is roaming")
    }
}

class Vet {
    fun giveShot(animal: Animal) {
        //Code to do something medical
        animal.makeNoise()
    }
}