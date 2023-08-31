package flow_test

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

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

    //flow jackson
    println("\nflow jackson:")
    println(Pack.pack().toString())
    val flow:Flow<String> = flow<String>{
        emit(Pack.pack().toString())
    }
    runBlocking<Unit> {
        flow.collect(){
            println("collect:${it}")
            val pack = UnPack.unPackPackage(UnPack.unpack(it))
            println("pack:${pack.command}")
        }
    }

    //SharedFlow
    println("\nshared flow:")
    runBlocking<Unit> {
        SharedFlow()
    }

    //StateFlow
    println("\nstate flow:")
    runBlocking<Unit> {
        StateFlow()
    }
}