/*
 * add something non-relevant into lambdas function
 */
object CalDefine {
    val cal: (Int, String) -> Double = { x: Int, y: String ->
        val z = x + y.toInt()
        println("doing what is not relevant to lambdas parameter and return value")
        z.toDouble()
        7.toDouble()
    }
}

object CalConcrete{
    val calConcrete: (Int,String) -> Double = CalDefine.cal
    fun funConcrete(x: Int,y: String,calConcrete: (x: Int, y: String) -> Double){
        println("calConcrete:${calConcrete(x,y)}.")
    }
}
