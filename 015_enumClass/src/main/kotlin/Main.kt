enum class Day(val dayOfWeek: Int) {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7),
    EIGHTDAY(8);

    companion object {
        fun fromInt(value: Int) = Day.values().first { it.dayOfWeek == value }
    }
}

enum class Day2(val dayOfWeek: Int,val printableName : String) {
    MONDAY(1,"MONDAY"){
        override fun calculateCashbackPercent() = 0.21f },
    TUESDAY(2,"TUESDAY"){
        override fun calculateCashbackPercent() = 0.22f },
    WEDNESDAY(3,"WEDNESDAY"){
        override fun calculateCashbackPercent() = 0.23f },
    THURSDAY(4,"THURSDAY"){
        override fun calculateCashbackPercent() = 0.24f },
    FRIDAY(5,"FRIDAY"){
        override fun calculateCashbackPercent() = 0.25f },
    SATURDAY(6,"SATURDAY"){
        override fun calculateCashbackPercent() = 0.26f },
    SUNDAY(7,"SUNDAY"){
        override fun calculateCashbackPercent() = 0.27f },
    EIGHTDAY(8,"EIGHTDAYhaha"){
        override fun calculateCashbackPercent() = 0.28f };

    abstract fun calculateCashbackPercent(): Float

    // custom method
    fun customToString(): String {
        return "[${dayOfWeek}] -> $printableName"
    }

    companion object {
        fun fromTable(firstParam: Int,secondParam:String) = Day2.values().first { firstParam == it.dayOfWeek && secondParam == it.printableName  }
    }
}

enum class BandMember(val instrument: String) {
    JERRY("lead guitar"),
    BOBBY("rhythm guitar"),
    PHIL("bass")
}

enum class MyEnum {
    A, B, C
}

//Int to Enum
inline fun <reified T : Enum<T>> Int.toEnum(): T? {
    return enumValues<T>().firstOrNull { it.ordinal == this }
}

//Enum to Int
inline fun <reified T : Enum<T>> T.toInt(): Int {
    return this.ordinal
}

fun main(args: Array<String>) {
    for (day in Day.values())
        println("[${day.ordinal}] -> ${day.name} (${day.dayOfWeek}^ day of the week)")

    for (day in Day2.values())
        println("[${day.ordinal}] -> ${day.name} (${day.dayOfWeek}^ day of the week)(printName:${day.printableName}) call:${day.customToString()}")

    println(Day2.FRIDAY.customToString())
    println(Day2.FRIDAY.calculateCashbackPercent())
    println("get attribute from table of Day:${Day.fromInt(8)}")
    println("get attribute from table of Day2:${Day2.fromTable(8,"EIGHTDAYhaha")}")

    var selectedBandMember: BandMember
    selectedBandMember = BandMember.JERRY
    println(selectedBandMember.instrument)

    //int to enum
    //enum to int
    val myEnumValue: MyEnum? = 1.toEnum<MyEnum>()
    println("Int to Enum : " + myEnumValue)
    val myIntValue = MyEnum.B.toInt()
    println("Enum to Int : " + myIntValue)

    //string to enum
    //enum to string
    val enumValue: FieldType? = FieldType from "31".toInt()
    println("string to Enum : " + enumValue)
    val intValue = FieldType.ELF_FIELD_SCALE_NUMBER.id
    println("Enum to Int : " + intValue)
    val strValue = FieldType.ELF_FIELD_SCALE_NUMBER.id.toString()
    println("Enum to String : " + strValue)
}