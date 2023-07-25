//Solution 1
enum class NumberV1(val value: Int) {
    ONE(1), TWO(2), THREE(3);

    companion object {
        infix fun from(value: Int): NumberV1? = NumberV1.values().firstOrNull { it.value == value }
    }
}

//Solution 2
enum class NumberV2(val value: Int) {
    ONE(1), TWO(2), THREE(3);

    companion object {
        private val map = NumberV2.values().associateBy { it.value }
        infix fun from(value: Int) = map[value]
    }
}

//Solution 3
enum class NumberV2Ex(val value: Int) {
    ONE(1), TWO(2), THREE(3);

    companion object {
        private val map = NumberV2.values().associateBy { it.value }
        operator fun get(value: Int) = map[value]
    }
}

//Solution 4
abstract class EnumFinder<V, E>(private val valueMap: Map<V, E>) {
    infix fun from(value: V) = valueMap[value]
}

enum class NumberV3(val value: Int) {
    ONE(1), TWO(2), THREE(3);

    companion object : EnumFinder<Int, NumberV3>(NumberV3.values().associateBy { it.value })
}

//Solution 5
infix inline fun <reified E : Enum<E>, V> ((E) -> V).findBy(value: V): E? {
    return enumValues<E>().firstOrNull { this(it) == value }
}
enum class NumberV4(val value: Int) {
    ONE(1), TWO(2), THREE(3),
}

enum class OS(val input: String) {
    Linux("linux"), MacOs("mac"),
}