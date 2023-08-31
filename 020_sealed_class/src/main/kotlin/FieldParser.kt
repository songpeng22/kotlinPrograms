sealed class ResultOfFieldParser
data class Success(var msg: String = "success") : ResultOfFieldParser()
data class Failure(var msg: String, var e: Exception) : ResultOfFieldParser()

object FieldParser {
    fun parse():ResultOfFieldParser{
        //return Success()
        return Failure("xml not exist",Exception("do it"))
    }
}