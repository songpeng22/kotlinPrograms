package flow_test

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper

//package
data class Body(var data:String = "")
data class Package(var command:String = "",var index:Int = 0,var body:Body? = null,var checksum:String? = "")
data class PackageACK(var command:String = "",var body:Body? = null,var checksum:String? = "")

object Pack{
    var isDebug:Boolean = true
    var TAG:String = "PackACK"
    val objectMapper = ObjectMapper()
    var rootNode:JsonNode? = null
    fun packPreInit(): Package?{
        return Package(command = "data",
            body = null,
            checksum = null)
    }
    fun packInit(): JsonNode{
        return objectMapper.valueToTree(packPreInit())
    }
    fun pack():JsonNode?{
        rootNode = packInit()

        return rootNode
    }
}