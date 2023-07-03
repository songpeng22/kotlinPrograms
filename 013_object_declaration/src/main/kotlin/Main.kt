//object expression
fun rentPrice(standardDays: Int, festivityDays: Int, specialDays: Int): Unit {  //1

    val dayRates = object {                                                     //2
        var standard: Int = 30 * standardDays
        var festivity: Int = 50 * festivityDays
        var special: Int = 100 * specialDays
    }

    val total = dayRates.standard + dayRates.festivity + dayRates.special       //3

    println("Total price: $$total")                                               //4

}

//object declaration
object DuckManager {
    var duckVar:String = "duck"
    fun herdDucks() {
        //Code to herd the Ducks
        println("this is ${duckVar}")
    }
}

//Companion Objects - like a static function
class BigBen {                                  //1
    companion object Bonger {                   //2
        fun getBongs(nTimes: Int) {             //3
            for (i in 1 .. nTimes) {
                print("BONG ")
            }
        }
    }
}

fun main(args: Array<String>) {
    //object expression
    rentPrice(10, 2, 1)
    //object declaration
    DuckManager.herdDucks();
    //Companion Objects
    BigBen.getBongs(12)

}