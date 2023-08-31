package flow_test

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow

suspend fun StateFlow() = runBlocking{
    // Create a StateFlow with an initial value of 0.
    val countStateFlow = MutableStateFlow(0)

    // Increase the counter by 1.
    countStateFlow.value = countStateFlow.value + 1

    // Listen to the StateFlow.
    runBlocking {
        delay(100)
        val listener = countStateFlow.collect { value ->
            println("The counter is now: $value")
        }
    }

    // Change the counter to 10.
    countStateFlow.value = 10
}