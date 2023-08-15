fun main(args: Array<String>) {
    //Scope - run -> change outer value
    println("\nscope run:")
    var tutorial = "This is Kotlin Tutorial"
    println(tutorial) //This is Kotlin Tutorial
    tutorial = run {
        val tutorial = "This is run function"
        tutorial
    }
    println(tutorial) //This is run function
    
    //Scope - let -> process and return, returns value is processed
    println("\nscope let:")
    var str = "Hello World"
    var ret = str.let { it + "!!!" }.let { it + "???" }
    println(ret)

    //Scope - also -> additional processing, returns original value 1
    println("\nscope also:")
    var m = 1
    m = m.also { it + 1 }.also { it + 1 }
    println(m) //prints 1

    //Scope - apply -> extension function on a type
    println("\nscope apply:")
    data class Person(var name: String, var tutorial : String)
    var person = Person("Anupam", "Kotlin")
    person.apply { this.tutorial = "Swift" }
    println(person)
    person.apply { tutorial = "Swift2" }.apply { tutorial = "Swift3" }
    println(person)
    person.also { it.tutorial = "Kotlin" }
    println(person)

    //Scope - with -> change properties like apply
    println("\nscope with:")
    data class Student(var name: String, var tutorial : String)
    var student = Student("Anupam", "Kotlin")
    var xyz = with(student)
    {
        name = "No Name"
        tutorial = "Kotlin tutorials"
        val xyz = "End of tutorial"
        xyz
    }
    println(xyz) //End of tutorial
}