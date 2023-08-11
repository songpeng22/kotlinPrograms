import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis
import org.junit.Assert
import org.junit.Assert.*
import org.junit.jupiter.api.*
import org.junit.jupiter.api.function.Executable
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import kotlin.time.*
import kotlin.time.Duration.Companion.milliseconds
import java.time.Instant
import java.util.Date

fun epoMill(){
    val begin = Instant.now().toEpochMilli()
    /* code starts */
    // sleep for 2 seconds
    Thread.sleep(2000)
    /* code ends */
    val end = Instant.now().toEpochMilli()
    println("Elapsed time in milliseconds: ${end-begin}ms")
}

fun getTime() {
    val begin = Date().time
    /* code starts */
    // sleep for 2 seconds
    Thread.sleep(2000)
    /* code ends */
    val end = Date().time
    println("Elapsed time in milliseconds: ${end-begin}ms")
}

fun main(args: Array<String>) {
    var variable:Int =  1
    println(variable)

    val elapsedMillis = measureTimeMillis {
        Thread.sleep(100)
        println("Measuring time via measureTimeMillis")
    }
    println("elapsedMillis:${elapsedMillis}ms")

    val elapsedNano = measureNanoTime {
        Thread.sleep(100)
        println("Measuring time via measureNanoTime")
    }
    println("elapsedNano:${elapsedNano/1000000}.${elapsedNano%1000000}ms")

    //Duration
    println("elapsedTime:${100.toDuration(DurationUnit.MILLISECONDS)}")

    //Calculate duration
    val begin = System.nanoTime()
    /* code starts */
    // sleep for 2 seconds
    Thread.sleep(2000)
    /* code ends */
    val end = System.nanoTime()
    println("Elapsed time in nanoseconds: ${end-begin}ns")

    //Calculate duration
    val begin2 = System.currentTimeMillis()
    /* code starts */
    // sleep for 2 seconds
    Thread.sleep(2000)
    /* code ends */
    val end2 = System.currentTimeMillis()
    println("Elapsed time in milliseconds: ${end2-begin2}ms")

    //
    epoMill()
    //
    getTime()
}