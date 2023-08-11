fun String.printVariabel(name:String = "this"):Unit{
    println("${name}:${this}")
}
fun Int.printVariabel():Unit{
    println("this:${this}")
}

fun main(args: Array<String>) {
    /*
     * String
     * :indexOf
     * :substring
     * Regex
     * */
    val str:String = "{\n" +
            "  \"command\" : \"label\",\n" +
            "  \"index\" : 63,\n" +
            "  \"body\" : {\n" +
            "    \"minetype\" : \"xml\",\n" +
            "    \"value\" : \"PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZ”\n" +
            "  },\n" +
            "  \"checksum\" : \"64\"\n" +
            "}"
    //solution 1, find index
    val bodyIndex = str.indexOf("body")
    bodyIndex.printVariabel()
    val pattern:Regex = Regex("body.*:.*\\{")
    //val bodyIndexOfRegex = str.matches(pattern).toString()
    val bodyIndexOfRegex = pattern.find(str)
    bodyIndexOfRegex?.value?.printVariabel("match value")
    bodyIndexOfRegex?.range.toString().printVariabel("match range")
    val checksumStartIndex:Int = bodyIndexOfRegex?.range?.last ?: -1
    val checksumIndex = str.indexOf("checksum")
    checksumIndex.printVariabel()
    val bodyEndIndex = str.lastIndexOf("},",checksumIndex) + 1
    bodyEndIndex.printVariabel()
    var body:String = ""
    if(checksumStartIndex != -1){
        body = str.substring(checksumStartIndex,bodyEndIndex)
        body.printVariabel()
    }
    "11".hashCode().printVariabel()

    //solution 2
    println("\nSolution 2:")
    //find body head
    var patternOfBody = Regex("body.*?\\{")
    var matchResult:MatchResult? = patternOfBody.find(str)
    matchResult?.range.toString().printVariabel("matched range of body head")
    matchResult?.value?.printVariabel("matched value of body head")
    var bodyHeadEnd:Int = matchResult?.range?.last ?: -1
    //find body full
    patternOfBody = Regex("\\{([^}]*?)\\}")
    if(bodyHeadEnd != -1){
        matchResult = patternOfBody.find(str,bodyHeadEnd - 1)
        var lastOfBody = matchResult?.range?.last ?: -1
        if(lastOfBody != -1){
            matchResult?.value?.printVariabel("matched value of body full")
            matchResult?.range.toString().printVariabel("matched range of body full")
        }
    }



//    var patternOfBody = Regex("body.*\\{([^}]*?)\\}")
//    var matchResult:MatchResult? = patternOfBody.find(str)
//    var lastOfBody = matchResult?.range?.last ?: -1
//    if(lastOfBody != -1){
//        matchResult = patternOfBody.find(str)
//        matchResult?.value?.printVariabel("matched value")
//        matchResult?.range.toString().printVariabel("matched range")
//    }



}