fun String.printVariabel():Unit{
    println("this:${this}")
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
    val bodyIndex = str.indexOf("body")
    bodyIndex.printVariabel()
    val pattern:Regex = Regex("body.*:.*\\{")
    //val bodyIndexOfRegex = str.matches(pattern).toString()
    val bodyIndexOfRegex = pattern.find(str)
    bodyIndexOfRegex?.value?.printVariabel()
    bodyIndexOfRegex?.range.toString().printVariabel()
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

}