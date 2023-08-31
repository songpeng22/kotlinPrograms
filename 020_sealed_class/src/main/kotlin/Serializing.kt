import kotlinx.serialization.Serializable
import com.fasterxml.jackson.annotation.JsonCreator

@Serializable
data class Data(val a: Int, val b: String)

@Serializable
sealed class ResultOf(var ret:Boolean){
    companion object {
        @JsonCreator
        @JvmStatic
        fun findBySimpleClassName(simpleName: String): ResultOf? {
            return ResultOf::class.sealedSubclasses.first {
                it.simpleName == simpleName
            }.objectInstance
        }
    }
}
@Serializable
data class ResultSuccess(var msg: String = "success") : ResultOf(true)
data class ResultFailure(var msg: String, var e: Exception) : ResultOf(false)

//val model = serializationModel(
//    LoginRequestEvent.ReuseSession::class,
//    LoginRequestEvent.CreateSession::class
//)

