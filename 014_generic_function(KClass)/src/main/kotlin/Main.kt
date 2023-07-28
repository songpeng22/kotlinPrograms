import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

data class User(val name: String)
data class Student(val name: String)

fun getUsers(): List<User> = listOf(User("JB"))
fun getStudents(): List<Student> = listOf(Student("Claire"))

fun <T: Any> getData(clazz: KClass<T>): List<T>? {
    return when(clazz) {
        User::class -> getUsers() as List<T>
        Student::class -> getStudents()  as List<T>
        else -> null
    }
}

class MainActivity{
    val name:String = "MainActivity"
}

class School{
    constructor(){
        println("School is constructed().")
    }

    fun tellWhoIAm(){
        println("this is School.")
    }

    //return KClass
    fun kclass():KClass<School>{
        println("this is school.")
        return School::class
    }

    fun tellKClass(kclass: KClass<School>){
        println(kclass)
    }
}

class KclassAsGenerics
class Generics<T>{
    fun print(t:T){
        println(t)
    }
}

fun main(args: Array<String>) {
    //获取类的KClass
//    val kClass = MainActivity::class
//    kClass.members.forEach {
//        println("memberProperties $it")
//    }

    //KClss -> instance
    val school = School::class.createInstance()
    //
    println("\nname to class:")
    val namedClass:Any = Class.forName(School::class.simpleName).kotlin.createInstance()
    val schoolAny = namedClass as School
    schoolAny.tellWhoIAm()

    //return KClass
    println("\nreturn KClass:")
    val schoolClass = school.kclass()
    schoolClass.createInstance()
    //tell KClass
    school.tellKClass(School::class)
    //KClass as generics
    Generics<KClass<KclassAsGenerics>>().print(KclassAsGenerics::class)

    //KClass -> when -> listOf Class instance
    val types = listOf(User::class, Student::class)
    types.forEach { type ->
        val data = getData(type)
        println(data)
    }
}