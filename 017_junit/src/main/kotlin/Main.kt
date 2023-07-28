import org.junit.Assert
import org.junit.Assert.*
import org.junit.jupiter.api.*
import org.junit.jupiter.api.function.Executable
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import kotlin.math.*

class Sample() {
    fun sum(a: Int, b: Int): Int {
        return a + b
    }
}

class SampleTest() {
    @Test
    fun testSum() {
        val expected = 42
        val sample = Sample()
        assertEquals(expected, sample.sum(40, 2))
    }
}

class Calculator() {
    fun add(a: Int, b: Int): Int {
        return a + b
    }

    fun square(a:Int):Int {
        return a * a
    }

    fun logxy(a: Int, b: Int): Double {
        return kotlin.math.log(b.toDouble(),a.toDouble()).toDouble()
    }
}

class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun `Adding 1 and 3 should be equal to 4`() {
        Assert.assertEquals(4, calculator.add(1, 3))
        Assertions.assertEquals(4, calculator.add(1, 3))
    }

    @Test
    @DisplayName("The square of a number should be equal to that number multiplied in itself")
    fun squareTest() {
        Assertions.assertAll(
            "calculate",
            Executable { Assertions.assertEquals(1, calculator.square(1)) },
            Executable { Assertions.assertEquals(4, calculator.square(2)) },
            Executable { Assertions.assertEquals(9, calculator.square(3)) }
        );
    }

    /*
     * TestFactory - multiple assert
     * */
    @TestFactory
    fun testSquares() = listOf(
        DynamicTest.dynamicTest("when I calculate 1^2 then I get 1") { Assertions.assertEquals(1,calculator.square(1))},
        DynamicTest.dynamicTest("when I calculate 2^2 then I get 4") { Assertions.assertEquals(4,calculator.square(2))},
        DynamicTest.dynamicTest("when I calculate 3^2 then I get 9") { Assertions.assertEquals(9,calculator.square(3))}
    )

    @TestFactory
    fun testSquares2() = listOf(
        1 to 1,
        2 to 4,
        3 to 9,
        4 to 16,
        5 to 25)
        .map { (input, expected) ->
            DynamicTest.dynamicTest("when I calculate $input^2 then I get $expected") {
                Assertions.assertEquals(expected, calculator.square(input))
            }
        }

    private val squaresTestData = listOf(
        1 to 1,
        2 to 4,
        3 to 9,
        4 to 16,
        5 to 25)
    @TestFactory
    fun testSquares3() = squaresTestData
        .map { (input, expected) ->
            DynamicTest.dynamicTest("when I calculate $input^2 then I get $expected") {
                Assertions.assertEquals(expected, calculator.square(input))
            }
        }

    /*
     * ParameterizedTest
     * */
    @ParameterizedTest
    @MethodSource("squares2")
    fun testSquares(input: Int, expected: Int) {
        Assertions.assertEquals(expected, input * input)
    }

    companion object {
        @JvmStatic
        fun squares() = listOf(
            Arguments.of(1, 1),
            Arguments.of(2, 4)
        )

        @JvmStatic
        fun squares2() = listOf(
            Arguments.of(3, 9),
            Arguments.of(4, 16)
        )
    }

    @ParameterizedTest
    @CsvSource(
        "1, 1",
        "2, 4",
        "3, 9"
    )
    fun testSquares2(input: Int, expected: Int) {
        Assertions.assertEquals(expected, input * input)
    }

    // JVM bytecode: @Tag.Container(value = {@Tag("slow"), @Tag("logarithms")})
    @Tag("slow") @Tag("logarithms")
    @Test
    fun `Repeatable Tag Log to base 2 of 8 should be equal to 3`() {
        Assertions.assertEquals(3.0, calculator.logxy(2, 8))
    }
}

fun main(args: Array<String>) {
    val calculator = Calculator()
    println("calculator:${calculator.add(1,2)}")
    val calculatorTest = CalculatorTest()
    //calculator.squareTest()
}