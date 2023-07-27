import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.channels.*

/*
 * 1st channel
 * Deferred values provide a convenient way to transfer a single value between coroutines.
 * Channels provide a way to transfer a stream of values.
 * */
suspend fun doChannel() = coroutineScope {  // this: CoroutineScope
    val channel = Channel<Int>()
    launch {
        // this might be heavy CPU-consuming computation or async logic, we'll just send five squares
        for (x in 1..5) {
            println("sending:${x * x}")
            channel.send(x * x)
        }
    }
    // here we print five received integers:
    repeat(5) { println(channel.receive()) }
    println("Done!")
}