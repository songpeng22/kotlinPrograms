import java.util.regex.Pattern

fun String.printVariabel(name:String = "this"):Unit{
    println("${name}:${this}")
}
fun Int.printVariabel():Unit{
    println("this:${this}")
}

val nameSolution1 = object : Any() {

}.javaClass.enclosingMethod?.name
val nameSolution2 = object{}.javaClass.enclosingMethod?.name

fun StringBuilder.getCutBody(): StringBuilder?{
    val pattern:Regex = Regex("body.*?\\{([^}]*?)\\}")
    val matchResult:MatchResult? = pattern.find(this.toString())
    matchResult?.value.toString().printVariabel("getCutBody")
    matchResult?.range.toString().printVariabel("getCutBody")
//    var first:Int = matchResult?.range?.first ?: 0
//    var last:Int = matchResult?.range?.last ?: 0
//    println("first:${first},last:${last}")
    if( matchResult?.range?.first != -1 && matchResult?.range?.last != -1){
        //this.delete( first , last+ 1)
        this.delete( matchResult?.range?.first ?: 0 , matchResult?.range?.last ?: 0 + 1)
    }

    return this
}

fun String.getOnePackage(): String?{
    val isDebug:Boolean = true
    val pattern:Regex = Regex("\\{([^}]*?)command.*?checksum([^}]*?)\\}", RegexOption.DOT_MATCHES_ALL)

    val matchResult:MatchResult? = pattern.find(this)
    if(isDebug){
        println(matchResult?.range)
        println(matchResult?.value)
    }
    return matchResult?.value ?: null
}

fun getFunctionName(){
    println("function name:${nameSolution2}")
}

fun main(args: Array<String>) {
    //function name
    getFunctionName()

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
            "}" +
            "{\n" +
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

    //cut body
    println("\ncut body:")
    val stringBuilderEx:StringBuilder = StringBuilder()
    stringBuilderEx.append(str)
    stringBuilderEx.toString().printVariabel("cut body")
    var bodyElimate = stringBuilderEx.getCutBody()
    bodyElimate.toString().printVariabel("cut body")

    //cut package
    println("\ncut package:")
    stringBuilderEx.clear()
    stringBuilderEx.append(str)
    str.printVariabel("cut package")
    str.getOnePackage()

    //StringBuilder
    println("\nStringBuilder:")
    val stringBuilder = StringBuilder()
    stringBuilder.append("123456")
    var string:String = stringBuilder.toString()
    string.printVariabel("string")
    stringBuilder.delete(string.indexOf("3"),string.indexOf("5") + 1)
    string = stringBuilder.toString()
    string.printVariabel("string")





}