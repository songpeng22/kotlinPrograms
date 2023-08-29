package flow_test

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

suspend fun delayedSimple(): List<Int> {
    delay(1000) // pretend we are doing something asynchronous here
    return listOf(1, 2, 3)
}

fun sequenceSimple(): Sequence<Int> = sequence { // sequence builder
    for (i in 1..3) {
        Thread.sleep(100) // pretend we are computing it
        yield(i) // yield next value
    }
}

fun flowSimple(): Flow<Int> = flow { // flow builder
    for (i in 1..3) {
        delay(100) // pretend we are doing something useful here
        emit(i) // emit next value
    }
}

fun flowIsColdSimple(): Flow<Int> = flow {
    println("Flow started")
    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}

fun flowCancelSimple(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100)
        println("Emitting $i")
        emit(i)
    }
}

fun main(args: Array<String>) {
    //minimal flow
    println("\nsimple flow:")
    val flowWithSingleValue = flow { emit(0) }
    println("flowWithSingleValue:${flowWithSingleValue}")
    runBlocking<Unit> {
        flowWithSingleValue.collect() { println(it) }
    }

    //basic flow
    println("\nbasic flow:")
    runBlocking<Unit> {
        (1..3).asFlow().collect { value -> println(value) }
    }

    //flow from list
    val flowFromList = listOf("mene", "mene", "tekel", "upharsin").asFlow()

    //normal data transfer vs
    //synchronous data transfer(Sequence)
    //asynchronous data transfer(Flow)
    println("\nsynchronous vs asynchronous:")
    runBlocking<Unit> {
        delayedSimple().forEach { value -> println(value) }
    }
    println("\nsequence:")
    sequenceSimple().forEach { value -> println(value) }
    println("\nflow:")
    runBlocking<Unit> {
        // Launch a concurrent coroutine to check if the main thread is blocked
        launch {
            for (k in 1..3) {
                log("I'm not blocked $k")
                delay(100)
            }
        }
        // Collect the flow
        flowSimple().collect { value -> log(value.toString()) }
    }

    //flow is cold
    println("\nflow is cold:")
    runBlocking<Unit> {
        println("Calling simple function...")
        val flow = flowIsColdSimple()
        println("Calling collect...")
        flow.collect { value -> println(value) }
        println("Calling collect again...")
        flow.collect { value -> println(value) }
    }

    //flow cancel
    println("\nflow cancel:")
    runBlocking<Unit> {
        withTimeoutOrNull(250) { // Timeout after 250ms
            flowCancelSimple().collect { value -> println(value) }
        }
        println("Done")
    }

}