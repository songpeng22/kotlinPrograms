import kotlinx.coroutines.*
import kotlinx.coroutines.debug.State
import kotlinx.coroutines.flow.*

class Counter {
    private val _mutableCounter = MutableStateFlow(0)
    val mCounter: StateFlow<Int> = _mutableCounter.asStateFlow()

    fun increment() {
        _mutableCounter.update { counter -> counter + 1 }
    }

    fun decrement() {
        _mutableCounter.update { counter -> counter - 1 }
    }
}

fun main(args: Array<String>) = runBlocking{
    /*
     * StateFlow
     * By using StateFlow, we can easily manage complex state changes in our application
     * without having to worry about race conditions or other concurrency issues.
     * */
    val counter = Counter()
    // Launch a coroutine to collect and print the count
    launch {
        while (isActive){
            println("+collecting...")
            counter.mCounter.collect { count ->
                println("Count: $count")
            }
            println("-collecting...")
            println("exiting......")
        }
    }
    launch {
        while (isActive){
            println("updating...")
            counter.increment()
            delay(1000)
        }
    }
    while (true){
        delay(1000)
    }
}