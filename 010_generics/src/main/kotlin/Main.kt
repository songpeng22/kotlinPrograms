fun main(args: Array<String>) {
    val catFuzz = Cat("Fuzz Lightyear")
    val catKatsu = Cat("Katsu")
    val fishFinny = Fish("Finny McGraw")

    val catVet = Vet<Cat>()
    val fishVet = Vet<Fish>()
    val petVet = Vet<Pet>()
    catVet.treat(catFuzz)
    petVet.treat(catKatsu)
    petVet.treat(fishFinny)

    val catContest = Contest<Cat>(catVet)
    catContest.addScore(catFuzz, 50)
    catContest.addScore(catKatsu, 45)

    val topCat = catContest.getWinners().first()
    println("Cat contest winner is ${topCat.name}")

    val petContest = Contest<Pet>(petVet)
    petContest.addScore(catFuzz, 50)
    petContest.addScore(fishFinny, 56)

    val topPet = petContest.getWinners().first()
    println("Pet contest winner is ${topPet.name}")

    //contravariant type, in lets you use a generic supertype in place of a subtype
    //Assign a Vet<Cat> to the Contest<Cat>.
    val fishContest = Contest<Fish>(petVet)

    val dogRetailer: Retailer<Dog> = DogRetailer()
    val catRetailer: Retailer<Cat> = CatRetailer()
    val petRetailer: Retailer<Pet> = CatRetailer()
    petRetailer.sell()

    //Bizerba Label and field
    println("\n(id,type) convert to type begin:")
    val h = LabelHandler<FieldData,FieldType>()
    val ft = FieldData("32","6")
    h.addTypeMap(FieldData("31","6"),CodeFieldType())
    h.addTypeMap(FieldData("32","6"),CodeFieldType())
    h.addTypeMap(FieldData("236","6"),FieldType("236","6"))
    h.addTypeMap(FieldData("131","4"),FixedTextFieldType())
    h.addTypeMap(FieldData("73", "4"),ArticleTextFieldType())
    h.getType(ft)?.tell()
    //
    println("\nenum convert to type begin:")
    val h2 = LabelHandler<FieldDataEx,FieldType>()
    h2.addTypeMap(FieldDataEx.ELF_FIELD_CODE_01,CodeFieldType())
    h2.addTypeMap(FieldDataEx.ELF_FIELD_DOD_BAR_CODE,FieldType("236","6"))
    h2.addTypeMap(FieldDataEx.ELF_FIELD_ARTICLE_TEXT,ArticleTextFieldType())
    h2.getType(FieldDataEx.ELF_FIELD_DOD_BAR_CODE)?.tell()
    h2.getType(FieldDataEx.ELF_FIELD_ARTICLE_TEXT)?.tell()
    //string or int -> enum class value
    //enum class value -> getType
    println("\nstring -> enum -> type begin:")
    val enumValue: FieldDataEx? = FieldDataEx from "31".toInt()
    h2.getType(enumValue)?.tell()
    //
    val enumValueUnknown: FieldDataEx? = FieldDataEx from "3111".toInt()
    println("enumValueUnknown:${enumValueUnknown}")
    val normlFieldType:FieldType = h2.getType(enumValueUnknown) ?: FieldType("","")
    normlFieldType.tell()
}