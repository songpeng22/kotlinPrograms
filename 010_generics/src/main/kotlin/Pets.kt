abstract class Pet(var name: String)

class Cat(name: String) : Pet(name)
class Dog(name: String) : Pet(name)
class Fish(name: String) : Pet(name)

class Vet<T: Pet> {
    fun treat(t: T) {
        println("Treat Pet ${t.name}")
    }
}

class Contest<T: Pet>(var vet: Vet<in T>) {
    val scores: MutableMap<T, Int> = mutableMapOf()
    fun addScore(t: T, score: Int = 0) {
        if (score >= 0) scores.put(t, score)
    }
    fun getWinners(): MutableSet<T> {
        val winners: MutableSet<T> = mutableSetOf()
        val highScore = scores.values.max()
        for ((t, score) in scores) {
            if (score == highScore) winners.add(t)
        }
        return winners
    }
}

interface Retailer<out T> {
    fun sell(): T
}

//out allows you to use a generic subtype in place of a supertype
//(like assigning a Retailer<Cat> to a Retailer<Pet>),
class CatRetailer : Retailer<Cat> {
    override fun sell(): Cat {
        println("Sell Cat")
        return Cat("")
    }
}

class DogRetailer : Retailer<Dog> {
    override fun sell(): Dog {
        println("Sell Dog")
        return Dog("")
    }
}

class FishRetailer : Retailer<Fish> {
    override fun sell(): Fish {
        println("Sell Fish")
        return Fish("")
    }
}

data class FieldData(var id:String,var type:String) {
    fun tell(){
        println("this is normal FieldType.")
    }
}

open class FieldType(open var id:String,open var type:String){
    open fun tell(){
        println("this is normal FieldType.")
    }
}

class CodeFieldType(id:String = "31",type:String = "6") : FieldType(id,type)
{
    override fun tell(){
        println("this is Code.")
    }
}

class FixedTextFieldType(id:String = "131",type:String = "4") : FieldType(id,type){
    override fun tell(){
        println("this is Fixed Text.")
    }
}

class ArticleTextFieldType(id:String = "73",type:String = "4") : FieldType(id,type){
    override fun tell(){
        println("this is Fixed Text")
    }
}

class LabelHandler<T,R:FieldType>{
    val typesMap: MutableMap<T, R> = mutableMapOf()

    init {

    }
    fun addTypeMap(t: T, r:R) {
        typesMap.put(t, r)
    }
    fun getType(t: T?):R? {
        for ((tInner, rInner) in typesMap) {
            if(t == tInner){
                println("matched:${tInner}:${rInner}")
                return rInner
            }
        }
        return null
    }
}

enum class FieldDataEx(
    val id: Int,
//    val description: String,
//    val content: String,
) {
    // Code fields

    // Code 01
//    ELF_FIELD_CODE_01(31, "Code 01", "111111111111"),
    ELF_FIELD_CODE_01(31),
    // Code 02
    ELF_FIELD_CODE_02(32),
    // DOD bar code
    ELF_FIELD_DOD_BAR_CODE(236),

    // Customer fields

    // Customer field code
    ELF_FIELD_CUSTOMER_FIELD_CODE(243),
    // Customer field logo
    ELF_FIELD_CUSTOMER_FIELD_LOGO(244),
    // Customer field text
    ELF_FIELD_CUSTOMER_FIELD_TEXT(242),

    // Date fields

    // Clock 01
    ELF_FIELD_CLOCK_01(36),
    // Date 01
    ELF_FIELD_DATE_01(27),
    // Date 02
    ELF_FIELD_DATE_02(28),
    // Date 03
    ELF_FIELD_DATE_03(29),
    // Date text 01
    ELF_FIELD_DATE_TEXT_01(22),
    // Date text 02
    ELF_FIELD_DATE_TEXT_02(23),
    // Date text 03
    ELF_FIELD_DATE_TEXT_03(24),

    // Fixed data fields

    // Fixed logo
    ELF_FIELD_FIXED_LOGO(240),
    // Fixed text
    ELF_FIELD_FIXED_TEXT(131),

    // Graphic fields

    // Border 02
    ELF_FIELD_BORDER_02(55),
    // Border or line
    ELF_FIELD_BORDER_OR_LINE(54),
    // Calibration area
    ELF_FIELD_CALIBRATION_AREA(239),
    // Content bitmap
    ELF_FIELD_CONTENT_BITMAP(227),
    // Header logo
    ELF_FIELD_HEADER_LOGO(59),
    // Logo field 01
    ELF_FIELD_LOGO_FIELD_01(51),
    // Logo field 02
    ELF_FIELD_LOGO_FIELD_02(52),
    // Logo field 03
    ELF_FIELD_LOGO_FIELD_03(53),
    // Rectangle
    ELF_FIELD_RECTANGLE(130),

    // Number fields

    // Specific number
    // Article ID
    ELF_FIELD_ARTICLE_ID(108),
    // Branch ID
    ELF_FIELD_BRANCH_ID(109),
    // Device number
    ELF_FIELD_DEVICE_NUMBER(17),
    // Operator number
    ELF_FIELD_OPERATOR_NUMBER(14),
    // Pcs/package
    ELF_FIELD_PCS_OR_PACKAGE(19),
    // PLU number
    ELF_FIELD_PLU_NUMBER(11),
    // Running bon number
    ELF_FIELD_RUNNING_BON_NUMBER(16),
    // Scale number
    ELF_FIELD_SCALE_NUMBER(18),

    // Price fields

    // Difference price
    ELF_FIELD_DIFFERENCE_PRICE(49),
    // Difference price text
    ELF_FIELD_DIFFERENCE_PRICE_TEXT(50),
    // Discount text
    ELF_FIELD_DISCOUNT_TEXT(232),
    // Discount value
    ELF_FIELD_DISCOUNT_VALUE(233),
    // Foreign conversion rate
    ELF_FIELD_FOREIGN_CONVERSION_RATE(118),
    // Foreign currency price
    ELF_FIELD_FOREIGN_CURRENCY_PRICE(113),
    // Foreign currency unit price
    ELF_FIELD_FOREIGN_CURRENCY_UNIT_PRICE(112),
    // Foreign currency unit price unit
    ELF_FIELD_FOREIGN_CURRENCY_UNIT_PRICE_UNIT(114),
    // Foreign difference price
    ELF_FIELD_FOREIGN_DIFFERENCE_PRICE(120),
    // Foreign special unit price
    ELF_FIELD_FOREIGN_SPECIAL_UNIT_PRICE(116),
    // Foreign specific SP
    ELF_FIELD_FOREIGN_SPECIAL_SP(117),
    // Price
    ELF_FIELD_PRICE(7),
    // Price text
    ELF_FIELD_PRICE_TEXT(26),
    // Special price
    ELF_FIELD_SPECIAL_PRICE(8),
    // Special price text
    ELF_FIELD_SPECIAL_PRICE_TEXT(71),
    // Special unit price
    ELF_FIELD_SPECIAL_UNIT_PRICE(6),
    // Unit price
    ELF_FIELD_UNIT_PRICE(5),
    // Unit price unit
    ELF_FIELD_UNIT_PRICE_UNIT(21),

    // Text fields
    // Article text
    ELF_FIELD_ARTICLE_TEXT(73),
    // Data of origin
    ELF_FIELD_DATA_OF_ORIGIN(133),
    // Data of origin COOL
    ELF_FIELD_DATA_OF_ORIGIN_COOL(230),
    // DOD data
    ELF_FIELD_DOD_DATA(234),
    // DOD passport
    ELF_FIELD_DOD_PASSPORT(235),
    // Extra text
    ELF_FIELD_EXTRA_TEXT(237),
    // Footer text
    ELF_FIELD_FOOTER_TEXT(79),
    // General texts
    ELF_FIELD_GENERAL_TEXTS(132),
    // General text 1 of 4
    ELF_FIELD_GENERAL_TEXT_01(223),
    // General text 2 of 4
    ELF_FIELD_GENERAL_TEXT_02(224),
    // General text 3 of 4
    ELF_FIELD_GENERAL_TEXT_03(225),
    // General text 4 of 4
    ELF_FIELD_GENERAL_TEXT_04(226),
    // Header text
    ELF_FIELD_HEADER_TEXT(74),
    // Macro text
    ELF_FIELD_MACRO_TEXT(266),
    // Nutrition
    ELF_FIELD_NUTRITION(93),
    // Origin data COOL Trace/Tracking number
    ELF_FIELD_ORIGIN_DATA_COOL_TRACE(231),

    // Static text

    // Static text 01
    ELF_FIELD_STATIC_TEXT_01(146),
    // Static text 02
    ELF_FIELD_STATIC_TEXT_02(147),
    // Static text 03
    ELF_FIELD_STATIC_TEXT_03(148),
    // Static text 04
    ELF_FIELD_STATIC_TEXT_04(149),
    // Static text 05
    ELF_FIELD_STATIC_TEXT_05(150),
    // Static text 06
    ELF_FIELD_STATIC_TEXT_06(151),
    // Static text 07
    ELF_FIELD_STATIC_TEXT_07(152),
    // Static text 08
    ELF_FIELD_STATIC_TEXT_08(153),
    // Static text 09
    ELF_FIELD_STATIC_TEXT_09(154),
    // Static text 10
    ELF_FIELD_STATIC_TEXT_10(155),
    // Static text 11
    ELF_FIELD_STATIC_TEXT_11(156),
    // Static text 12
    ELF_FIELD_STATIC_TEXT_12(157),
    // Static text 13
    ELF_FIELD_STATIC_TEXT_13(158),
    // Static text 14
    ELF_FIELD_STATIC_TEXT_14(159),
    // Static text 15
    ELF_FIELD_STATIC_TEXT_15(160),
    // Static text 16
    ELF_FIELD_STATIC_TEXT_16(161),
    // Static text 17
    ELF_FIELD_STATIC_TEXT_17(162),
    // Static text 18
    ELF_FIELD_STATIC_TEXT_18(163),
    // Static text 19
    ELF_FIELD_STATIC_TEXT_19(164),
    // Static text 20
    ELF_FIELD_STATIC_TEXT_20(165),
    // Static text 21
    ELF_FIELD_STATIC_TEXT_21(166),
    // Static text 22
    ELF_FIELD_STATIC_TEXT_22(167),
    // Static text 23
    ELF_FIELD_STATIC_TEXT_23(168),
    // Static text 24
    ELF_FIELD_STATIC_TEXT_24(169),
    // Static text 25
    ELF_FIELD_STATIC_TEXT_25(170),
    // Static text 26
    ELF_FIELD_STATIC_TEXT_26(171),
    // Static text 27
    ELF_FIELD_STATIC_TEXT_27(172),
    // Static text 28
    ELF_FIELD_STATIC_TEXT_28(173),
    // Static text 29
    ELF_FIELD_STATIC_TEXT_29(174),
    // Static text 30
    ELF_FIELD_STATIC_TEXT_30(175),
    // Static text 31
    ELF_FIELD_STATIC_TEXT_31(176),
    // Static text 32
    ELF_FIELD_STATIC_TEXT_32(177),
    // Static text 33
    ELF_FIELD_STATIC_TEXT_33(178),
    // Static text 34
    ELF_FIELD_STATIC_TEXT_34(179),
    // Static text 35
    ELF_FIELD_STATIC_TEXT_35(180),
    // Static text 36
    ELF_FIELD_STATIC_TEXT_36(181),
    // Static text 37
    ELF_FIELD_STATIC_TEXT_37(182),
    // Static text 38
    ELF_FIELD_STATIC_TEXT_38(183),
    // Static text 39
    ELF_FIELD_STATIC_TEXT_39(184),
    // Static text 40
    ELF_FIELD_STATIC_TEXT_40(185),
    // Static text 41
    ELF_FIELD_STATIC_TEXT_41(186),
    // Static text 42
    ELF_FIELD_STATIC_TEXT_42(187),
    // Static text 43
    ELF_FIELD_STATIC_TEXT_43(188),
    // Static text 44
    ELF_FIELD_STATIC_TEXT_44(189),
    // Static text 45
    ELF_FIELD_STATIC_TEXT_45(190),
    // Static text 46
    ELF_FIELD_STATIC_TEXT_46(191),
    // Static text 47
    ELF_FIELD_STATIC_TEXT_47(192),
    // Static text 48
    ELF_FIELD_STATIC_TEXT_48(193),
    // Static text 49
    ELF_FIELD_STATIC_TEXT_49(194),
    // Static text 50
    ELF_FIELD_STATIC_TEXT_50(195),

    // Text field

    // Text field 01
    ELF_FIELD_TEXT_FIELD_01(61),
    // Text field 02
    ELF_FIELD_TEXT_FIELD_02(62),
    // Text field 03
    ELF_FIELD_TEXT_FIELD_03(63),
    // Text field 04
    ELF_FIELD_TEXT_FIELD_04(64),
    // Text field 05
    ELF_FIELD_TEXT_FIELD_05(65),
    // Text field 06
    ELF_FIELD_TEXT_FIELD_06(66),
    // Text field 07
    ELF_FIELD_TEXT_FIELD_07(67),
    // Text field 08
    ELF_FIELD_TEXT_FIELD_08(68),
    // Text field 09
    ELF_FIELD_TEXT_FIELD_09(69),
    // Text field 10
    ELF_FIELD_TEXT_FIELD_10(70),

    // Weight fields

    // Euro-E
    ELF_FIELD_EURO_E(72),
    // Mass
    ELF_FIELD_MASS(218),
    // Mass text
    ELF_FIELD_MASS_TEXT(217),
    // Net/fixed weight
    ELF_FIELD_NET_OR_FIXED_WEIGHT(92),
    // Piece
    ELF_FIELD_PIECE(220),
    // Piece text
    ELF_FIELD_PIECE_TEXT(219),
    // Tare
    ELF_FIELD_TARE(9),
    // Tare text
    ELF_FIELD_TARE_TEXT(10),
    // Weight
    ELF_FIELD_WEIGHT(1),
    // Weight text
    ELF_FIELD_WEIGHT_TEXT(25);

    companion object {
        infix fun from(value: Int): FieldDataEx? = FieldDataEx.values().firstOrNull { it.id == value }
    }
}
