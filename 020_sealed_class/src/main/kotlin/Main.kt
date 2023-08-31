import kotlinx.serialization.*
import kotlinx.serialization.json.Json

sealed class MessageType(open var msg: String)
class MessageSuccess(override var msg: String) : MessageType(msg)
class MessageFailure(override var msg: String, var e: Exception) : MessageType(msg)

fun main(args: Array<String>) {
    val messageSuccess = MessageSuccess("Yay!")
    val messageSuccess2 = MessageSuccess("It worked!")
    val messageFailure = MessageFailure("Boo!", Exception("Gone wrong."))


    var myMessageType: MessageType = messageFailure
    val myMessage = when (myMessageType) {
        is MessageSuccess -> myMessageType.msg
        is MessageFailure -> myMessageType.msg + " " + myMessageType.e.message
    }
    println(myMessage)

    //return sealed class as return value
    var ret = FieldParser.parse()
    val retText = when(ret){
        is Success -> ret.msg
        is Failure -> ret.msg + " " + ret.e.message
    }
    println(retText)

    //serialization/deserialization
    val json = Json.encodeToString(Data(42, "str"))
    val obj = Json.decodeFromString<Data>(json)
    println(obj.a)
//    val json2 = Json.encodeToString(ResultSuccess())
//    val obj2 = Json.decodeFromString<ResultOf>(json2)
//    println(obj2.ret)

//    val json2 = Json(Data(42, "str"))
//    val obj = Json.decodeFromString<ResultSuccess>(json)
//    println(obj.msg)
}