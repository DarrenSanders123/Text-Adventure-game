import kotlin.random.Random

class Search {

    @Suppress("PrivatePropertyName")
    public var Searched = 0
    public var maxSearches = Random.nextInt(1, 3)

    fun CheckSearches(): Boolean {
        return Searched <= maxSearches
    }

    fun ResetSearches() {
        Searched = 0
        maxSearches = Random.nextInt(1, 3)
    }

    fun Search() {
        if (CheckSearches()) {
            print("Searching =")
            var amount = 0
            while (amount < 10) {
                print("==")
                Thread.sleep(1000)
                amount++
            }
            println()
            val chanceToFindEnemy = Random.nextInt(1, 5).let { chance ->
                if (chance != 0) {
                    FoundAEnemy(GenerateRandom().GenerateEnemy())
                } else {
                    val chanceToFindItem = Random.nextInt(1, 3).let { chance ->
                        if (chance == 2) {
                            FoundAItem(GenerateRandom().GenerateItem())
                            Searched++
                            Option()
                        } else {
                            println("You found nothing")
                            Searched++
                            Option()
                        }

                    }
                }
            }
        }
        }

    @Suppress("MemberVisibilityCanBePrivate")
    fun FoundAItem(item: Items) {
        fun itemDisplay(item: Items) {
            val backpack = arrayOf("BUCKET", "ARROW", "BOOK")
            if (backpack.contains(item.name)) {
                if (item.name == "ARROW") {
                    var amount = Random.nextInt(1, 5)
                    println("${amount}x ${item.name} added to inventory.")
                    while (amount > 0) {
                        Inventory.AddItem(item)
                        amount -= 1
                    }
                } else {
                    println("1x ${item.name} added to inventory.")
                    Inventory.AddItem(item)
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
                Inventory.AddItem(item)
            }
        }
        itemDisplay(item)
    }

    private fun FoundAEnemy(enemy: Enemies) {
        fun enemyDisplay(enemy: Enemies) {
            println("""
                Oh no you stumbled across a ${enemy.name}.
                Inventory: ${Inventory.Show()}
                Options: 
                    Fight [${Inventory.InInventory(Items.SWORD)}]
                    Fight Bow [${Inventory.InInventory(Items.BOW)}](${Inventory.ShowCountOfItem(Items.ARROW)})
                    Run
                Stats: 
                    [hp: ${enemy.hp}, att: ${enemy.att}]
            """.trimIndent())
        }
        enemyDisplay(enemy)
        val option = readLine()!!
        if (option.toLowerCase() == "fight") {
            Player().FightOrDefend(Items.SWORD, enemy)
        } else if (option.toLowerCase() == "fight bow") {
            Player().FightOrDefend(Items.BOW, enemy)
        } else if (option.toLowerCase() == "run") {
            Player().run()
        } else {
            Main().OptionNotFound()
            FoundAEnemy(enemy)
        }
    }
    fun Option() {
        if (CheckSearches()) {
            println("""
                            Select a option:
                                [Search] again,
                                [Next Room]
                        """.trimIndent())
            val option = readLine()!!
            if (option.toLowerCase() == "search") {
                Search()
            } else if (option.toLowerCase() == "next room") {
                Rooms().GenerateRoom()
            } else {
                Main().OptionNotFound()
                Option()
            }
        } else {
            println("You have found everything in this room.")
            println("""
                            Select a option:
                                [Next Room]
                        """.trimIndent())
            val option = readLine()!!
            if (option.toLowerCase() == "next room") {
                Rooms().GenerateRoom()
            } else {
                Main().OptionNotFound()
                Option()
            }
        }
    }
}