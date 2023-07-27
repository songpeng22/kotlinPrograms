import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
 * first coroutines
 * print hello then delay 1s, and then print World!
 * */
fun firstCoroutines(){
    runBlocking { // this: CoroutineScope
        launch { // launch a new coroutine and continue
            delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
            println("World!") // print after delay
        }
        println("Hello") // main coroutine continues while a previous one is delayed
    }
}

/*
 * 2nd coroutines
 * suspend function
 * */
// this is your first suspending function
suspend fun doWorld() {
    delay(1000L)
    println("World!")
}

/*
 * 3rd coroutines - declare scope
 * */
suspend fun doWorldOfScope() = coroutineScope {  // this: CoroutineScope
    launch {
        delay(1000L)
        println("World!")
    }
    println("Hello")
}

/*
 * 4th coroutines - double launch
 * */
// Concurrently executes both sections
suspend fun doWorld4th() = coroutineScope { // this: CoroutineScope
    launch {
        delay(2000L)
        println("World 2")
    }
    launch {
        delay(1000L)
        println("World 1")
    }
    println("Hello")
}

/*
 * 5th coroutines
 * define launch as variable and join with it
 * */
suspend fun doWorld5th() = coroutineScope { // this: CoroutineScope
    val job = launch { // launch a new coroutine and keep a reference to its Job
        delay(1000L)
        println("World!")
    }
    println("Hello")
    job.join() // wait until child coroutine completes
    println("Done")
}

/*
 * 6th coroutines
 * coroutines consume less memory
 * */
suspend fun consume6th() = coroutineScope { // this: CoroutineScope
    repeat(50_000) { // launch a lot of coroutines
        launch {
            delay(5000L)
            print(".")
        }
    }
}

/*
 * 7th coroutines
 * !!! not understand here
 * */
class Yield{
    fun vowels() = sequence {
        yield("a")
        yield("e")
        yield("i")
        yield("o")
        yield("u")
    }
}

suspend fun coroutines7th() = coroutineScope { // this: CoroutineScope
    val client = Yield();
    val vowelIterator = client.vowels().iterator()
    while (vowelIterator.hasNext()) {
        println(vowelIterator.next())
    }
}
