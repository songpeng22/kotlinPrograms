fun main(args: Array<String>) {
    /*
     * When you run this code, you'll see that the filter() and map() functions are executed in the same order as they appear in the code.
     * */
    val words = "The quick brown fox jumps over the lazy dog".split(" ")
    println("words type is:${words::class.simpleName}\n")

    val lengthsList = words.filter {
        println("filter: $it");
        it.length > 3 }
        .map {
            println("length: ${it.length}");
            it.length }
        .take(4)

    println("Lengths of first 4 words longer than 3 chars:")
    println(lengthsList)

    /*
     * Sequence
     * */
    println("\nthis is how sequence does:")
    val words2 = "The quick brown fox jumps over the lazy dog".split(" ")
    //convert the List to a Sequence
    val wordsSequence = words2.asSequence()
    val lengthsSequence = wordsSequence.filter { println("filter: $it"); it.length > 3 }
        .map { println("length: ${it.length}"); it.length }
        .take(4)
    println("Lengths of first 4 words longer than 3 chars")
    // terminal operation: obtaining the result as a List
    println(lengthsSequence.toList())
}