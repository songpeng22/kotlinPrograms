import java.time.Instant

fun simple(): Sequence<Int> = sequence { // sequence builder
    for (i in 1..3) {
        Thread.sleep(100) // pretend we are computing it
        yield(i) // yield next value
    }
}

fun main(args: Array<String>) {
    //create sequence from element
    println("\nsequence from element:")
    val seqOfElements = sequenceOf("first" ,"second", "third")
    println("seqOfElements.count():${seqOfElements.count()}.")
    seqOfElements.forEach { element -> println(element) }
    seqOfElements.forEach { println(it) }

    //sequence from function
    println("\nsequence from function:")
    val seqFromFunction = generateSequence(Instant.now()) {it.plusSeconds(1)}
    //seqFromFunction.forEach { println(it) }

    //sequence from chunks:
    println("\nsequence from chunks:")
    val seqFromChunks = sequence {
        yield(1)
        yieldAll((2..5).toList())
    }
    seqFromChunks.forEach { println(it) }
    //
    simple().forEach { element -> println(element) }

    //sequence from collection
    println("\nsequence from collection:")
    val seqFromIterable = (1..10).asSequence()
    seqFromIterable.forEach { println(it) }

    //lazy or eager
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
     * Sequence - lazy operation
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