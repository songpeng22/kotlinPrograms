sealed class MessageType
class MessageSuccess(var msg: String) : MessageType()
class MessageFailure(var msg: String, var e: Exception) : MessageType()

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
}