import kotlinx.coroutines.*

fun main(args: Array<String>) {
    //first channel
    println("1st channel:")
    runBlocking { // this: CoroutineScope
        doChannel()
    }

    //first coroutines
    println("\n1st coroutines:")
    firstCoroutines()
    //2nd coroutines - suspend function
    println("\n2nd coroutines:")
    runBlocking { // this: CoroutineScope
        launch { doWorld() }
        println("Hello")
    }
    //3rd coroutines
    println("\n3rd coroutines:")
    runBlocking { // this: CoroutineScope
        doWorldOfScope()
    }
    //4th coroutines
    println("\n4th coroutines:")
    runBlocking { // this: CoroutineScope
        doWorld4th()
    }
    //5th coroutines
    println("\n5th coroutines:")
    runBlocking { // this: CoroutineScope
        doWorld5th()
    }
    //6th - coroutines consume less memory
    println("\n6th coroutines:")
    runBlocking { // this: CoroutineScope
        //consume6th()
    }
    //7th - sequence and yield
    //!!! not understand here -  think it state machine
    runBlocking { // this: CoroutineScope
        coroutines7th()
    }


}