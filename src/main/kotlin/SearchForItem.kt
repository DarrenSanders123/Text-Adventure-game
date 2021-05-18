import kotlin.random.Random

class SearchForItem {
    private var amountFound = 0
    private val maxItems = Random.nextInt(1, 3)
    @Suppress("PrivatePropertyName")
    private val Inventory = Inventory()

    fun Search() {
        if (this.amountFound <= maxItems) {
            val chanceToFindItem = Random.nextInt(1, 3)
            if (chanceToFindItem == 2) {
                FoundAItem(GenerateRandomItem().Generate())
            }
        }
    }

    @Suppress("MemberVisibilityCanBePrivate")
    fun FoundAItem(item: Items) {
        fun itemDisplay(item: Items) {
            val backpack = arrayOf("BUCKET", "ARROW", "BOOK")
            if (backpack.contains(item.name)) {
                if (item.name == "ARROW") {
                    val amount = Random.nextInt(1, 5)
                    println("${amount}x ${item.name} added to inventory.")
                    Inventory.add()
                    amountFound++
                } else {
                    println("1x ${item.name} added to inventory.")
                    Inventory.add()
                    amountFound++
                }
            } else {
                println(
                    """
                    New item:
                        Name: ${item.name}
                        Attack: ${item.dmg}
                        Durability: ${item.dur}
                """.trimIndent()
                )
            }
        }
        itemDisplay(item)
    }
}