package flow_test

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.runBlocking

suspend fun SharedFlow(){
    // Create a SharedFlow with a replay buffer of 10 items.
    val sharedFlow = MutableSharedFlow<Int>(replay = 10)

    val job1 = CoroutineScope(Dispatchers.IO).launch {
        sharedFlow.collect {
            println("Job 1: Received $it")
        }
    }

    val job2 = CoroutineScope(Dispatchers.IO).launch {
        sharedFlow.collect {
            println("Job 2: Received $it")
        }
    }

    val job3 = CoroutineScope(Dispatchers.IO).launch {
        delay(100)
        sharedFlow.emit(1)
        sharedFlow.emit(2)
        sharedFlow.emit(3)
    }

    job3.join() // Wait for job3 to complete

    // Emit another value to the SharedFlow.
    sharedFlow.emit(4)

    sharedFlow.resetReplayCache() // Reset the replay cache to clear buffered events

    val job4 = CoroutineScope(Dispatchers.IO).launch {
        sharedFlow.collect {
            println("Job 4: Received $it")
        }
    }

    job1.cancel() // Cancel job1
    job2.cancel() // Cancel job2
    job4.cancel() // Cancel job4

    sharedFlow.emit(3) // Won't be received by any active collectors
}