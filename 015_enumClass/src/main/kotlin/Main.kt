enum class Day(val dayOfWeek: Int) {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7)
}

enum class Day2(val dayOfWeek: Int,val printableName : String) {
    MONDAY(1,"MONDAY"),
    TUESDAY(2,"TUESDAY"),
    WEDNESDAY(3,"WEDNESDAY"),
    THURSDAY(4,"THURSDAY"),
    FRIDAY(5,"FRIDAY"),
    SATURDAY(6,"SATURDAY"),
    SUNDAY(7,"SUNDAY");

    // custom method
    fun customToString(): String {
        return "[${dayOfWeek}] -> $printableName"
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

    var selectedBandMember: BandMember
    selectedBandMember = BandMember.JERRY
    println(selectedBandMember.instrument)
}