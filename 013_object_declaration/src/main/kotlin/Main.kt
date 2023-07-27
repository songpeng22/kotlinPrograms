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

//object inside class - class factory
class Duck {
    object DuckFactory {
        fun create(): Duck = Duck()
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

/*
 * works as anonymous inner class in java
 *
    window.addMouseListener(object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent) {
            //Code that runs when the mouse is clicked
        }
        override fun mouseReleased(e: MouseEvent) {
            //Code that runs when the mouse is released
        }
    })
 * */

fun main(args: Array<String>) {
    //object expression
    rentPrice(10, 2, 1)
    //object declaration
    DuckManager.herdDucks();
    //object inside class - duck factory product duck
    val newDuck = Duck.DuckFactory.create()
    //Companion Objects - object name is not mentioned
    BigBen.getBongs(12)

}