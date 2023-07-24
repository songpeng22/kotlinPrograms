fun main(args: Array<String>) {
    val animals = arrayOf(Hippo(), Wolf())
    for (item in animals) {
        item.roam()
        item.eat()
    }
    val vet = Vet()
    val wolf = Wolf()
    val hippo = Hippo()
    vet.giveShot(wolf)
    vet.giveShot(hippo)

    println("roamables:")
    val roamables = arrayOf(Hippo(), Wolf(), Vehicle())
    for (item in roamables) {
        item.roam()
        if (item is Animal) {
            item.eat()
        }
    }

    println("add class with same interface into one list:")
    val roams1:List<Roamable> = listOf(Hippo(), Wolf(), Vehicle())
    for (item in roams1) {
        item.roam()
        if (item is Animal) {
            item.eat()
        }
    }
}