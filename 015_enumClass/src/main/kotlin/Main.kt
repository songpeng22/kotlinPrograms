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
}