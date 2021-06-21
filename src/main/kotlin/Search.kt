import kotlin.random.Random

class Search {
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
                println("""
                    New item:
                        Name: ${item.name}
                        Attack: ${item.dmg}
                        Durability: ${item.dur}
                """.trimIndent()
                )
                Inventory.AddItem(item)
            }
        }



    fun FoundAEnemy(enemy: Enemies) {
        fun enemyDisplay(enemy: Enemies) {
            println("""
                Oh no you stumbled across a ${enemy.name}.
                Inventory: ${Inventory.Show()}
                Options: 
                    Fight [${Inventory.InInventory(Items.SWORD)}]
                    Fight Bow [${Inventory.InInventory(Items.BOW)}](${Inventory.ShowCountOfItem(Items.ARROW)})
                    Fight OP [${Inventory.InInventory(Items.OP_SWORD)}]
                    Run
                Stats: 
                    [hp: ${enemy.hp}, att: ${enemy.att}]
            """.trimIndent())
        }
        enemyDisplay(enemy)
        val option = readLine()!!
        when {
            option.toLowerCase() == "fight" -> {
                Player().FightOrDefend(Items.SWORD, enemy)
            }
            option.toLowerCase() == "fight bow" -> {
                Player().FightOrDefend(Items.BOW, enemy)
            }
            option.toLowerCase() == "fight op" -> {
                Player().FightOrDefend(Items.OP_SWORD, enemy)
            }
            option.toLowerCase() == "run" -> {
                Player().run()
            }
            else -> {
                Tools().OptionNotFound()
                FoundAEnemy(enemy)
            }
        }
    }
}