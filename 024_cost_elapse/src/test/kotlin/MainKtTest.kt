import org.junit.jupiter.api.Assertions.*
import kotlin.system.measureTimeMillis

import kotlin.test.Test
import kotlin.test.assertEquals

internal class SampleTest {

    val elapsed = measureTimeMillis {
        Thread.sleep(100)
        println("Measuring time via measureTimeMillis")
    }

    @Test
    fun testSum() {
        //assertThat(elapsed).isGreaterThanOrEqualTo(100)
    }
}