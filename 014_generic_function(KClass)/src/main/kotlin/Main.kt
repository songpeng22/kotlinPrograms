import kotlin.reflect.KClass

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

fun main(args: Array<String>) {
    //获取类的KClass
//    val kClass = MainActivity::class
//    kClass.members.forEach {
//        println("memberProperties $it")
//    }
    //
    val types = listOf(User::class, Student::class)
    types.forEach { type ->
        val data = getData(type)
        println(data)
    }
}