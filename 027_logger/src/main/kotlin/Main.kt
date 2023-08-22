import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import samples.log

fun main(args: Array<String>) {
    println("\nmain().")
    runBlocking<Unit> {
        val channel = Channel<String>()
        launch {
            channel.send("A1")
            channel.send("A2")
            log("A done")
        }
        launch {
            channel.send("B1")
            log("B done")
        }
        launch {
            println("launch::before repeat:")
            repeat(3) {
                println("\nlaunch() + channel.receive()")
                val x = channel.receive()
                println("\nlaunch() - channel.receive()")
                log(x)
            }
        }
    }
}