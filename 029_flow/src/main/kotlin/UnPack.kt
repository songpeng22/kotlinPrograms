package flow_test

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper

object UnPack{
    var isDebug:Boolean = true
    var isDebugFull:Boolean = true
    var TAG:String = "UnPack_PLU"
    //Jackson
    var rootNode:JsonNode? = null
    val objectMapper = ObjectMapper()
    fun unpack(onePackage:String?):JsonNode?{
        rootNode = objectMapper.readTree(onePackage)

        return rootNode
    }
    fun unPackPackage(node:JsonNode?):Package{
        val pack:Package =  objectMapper.treeToValue(node,Package::class.java)

        return pack
    }
}