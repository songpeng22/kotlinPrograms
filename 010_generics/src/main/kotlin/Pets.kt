abstract class Pet(var name: String)

class Cat(name: String) : Pet(name)
class Dog(name: String) : Pet(name)
class Fish(name: String) : Pet(name)

class Vet<T: Pet> {
    fun treat(t: T) {
        println("Treat Pet ${t.name}")
    }
}

class Contest<T: Pet>(var vet: Vet<in T>) {
    val scores: MutableMap<T, Int> = mutableMapOf()
    fun addScore(t: T, score: Int = 0) {
        if (score >= 0) scores.put(t, score)
    }
    fun getWinners(): MutableSet<T> {
        val winners: MutableSet<T> = mutableSetOf()
        val highScore = scores.values.max()
        for ((t, score) in scores) {
            if (score == highScore) winners.add(t)
        }
        return winners
    }
}

interface Retailer<out T> {
    fun sell(): T
}

//out allows you to use a generic subtype in place of a supertype
//(like assigning a Retailer<Cat> to a Retailer<Pet>),
class CatRetailer : Retailer<Cat> {
    override fun sell(): Cat {
        println("Sell Cat")
        return Cat("")
    }
}

class DogRetailer : Retailer<Dog> {
    override fun sell(): Dog {
        println("Sell Dog")
        return Dog("")
    }
}

class FishRetailer : Retailer<Fish> {
    override fun sell(): Fish {
        println("Sell Fish")
        return Fish("")
    }
}

data class FieldData(var id:String,var type:String) {
    fun tell(){
        println("this is normal FieldType.")
    }
}

open class FieldType(open var id:String,open var type:String){
    open fun tell(){
        println("this is normal FieldType.")
    }
}

class CodeFieldType(id:String = "31",type:String = "6") : FieldType(id,type)
{
    override fun tell(){
        println("this is Code.")
    }
}

class FixedTextFieldType(id:String = "131",type:String = "4") : FieldType(id,type){
    override fun tell(){
        println("this is Fixed Text.")
    }
}

class ArticleTextFieldType(id:String = "73",type:String = "4") : FieldType(id,type){
    override fun tell(){
        println("this is Fixed Text")
    }
}

class LabelHandler<T:FieldData,R:FieldType>{
    val typesMap: MutableMap<T, R> = mutableMapOf()
    fun addTypeMap(t: T, r:R) {
        typesMap.put(t, r)
    }
    fun getType(t: T?):R? {
        for ((tInner, rInner) in typesMap) {
            if(t == tInner){
                println("matched:${tInner}:${rInner}")
                return rInner
            }
        }
        return null
    }
}
