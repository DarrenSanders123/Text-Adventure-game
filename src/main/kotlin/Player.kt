import javax.tools.Tool
import kotlin.math.ln
import kotlin.random.Random

class Player() {
    private var health = 100f; var defence = 1f;
    private var defending = false;
    fun fight(item: Items, enemy: Enemies) {
        println("=======================================" +
                "\nYou:" +
                "\n   HP: $health" +
                "   DEF: $defence" +
                "   ATT: ${item.dmg} [${item.name.toLowerCase()}]")
        print("========================================" +
                "\nEnemy:" +
                "\n   HP: ${enemy.hp}" +
                "   DEF: ${enemy.def}" +
                "   ATT: ${enemy.att}")
        if (item == Items.BOW) {
            if (Inventory.CountOfItem(Items.ARROW) >= 1) {
                TryAttack(Items.BOW, enemy)
            } else {
                println("\nyou're out of arrows, use your sword now.")
                TryAttack(Items.SWORD, enemy)
            }
        } else {
            TryAttack(item, enemy)
        }
    }

    fun defend(item: Items, enemy: Enemies) {
        println("You defended.")
        defending = true
        FightOrDefend(item, enemy)
    }
    fun run() {
        println("You ran away.")
        Tools().clearScreen()
    }

    fun TryAttack(item: Items, enemy: Enemies) {
        val chance = Random.nextInt(1, 4)
        println("\nFighting ")
        var amount = 0
            while (amount < 10) {
                print("==")
                Thread.sleep(500)
                amount++
            }

        if (chance == 1 || chance == 2) {
            if (Inventory.InInventoryBool(item)) {
                Attack(item, enemy)
            }
        } else {
            println("\nYou missed your attack.")
            if (!defending) {
                Damage(enemy.att.toFloat())
            } else {
                defending = false
            }
            FightOrDefend(item, enemy)
        }
    }

    private fun Attack(item: Items, enemy: Enemies) {
        enemy.hp -= (item.dmg / enemy.def)
        println("\nYou hit the enemy and did ${item.dmg / enemy.def} HP damage to the enemy.")
        if (item.name == "BOW") {
            Inventory.RemoveItem(Items.ARROW)
        }
        FightOrDefend(item, enemy)
    }

    fun Damage(amount: Float) {
        health -= (amount / defence)
        println("The enemy hit you and did ${amount / defence} HP damage to you.")
    }
    fun HealAmount(amount: Float) {
        health += amount
    }
    fun HealAll() {
        health = 100f
    }
    fun FightOrDefend(item: Items, enemy: Enemies) {
        if (health <= 0) {
            println("You died")
            Main().EndGame("")
        } else if (enemy.hp <= 0) {
            println("You killed the enemy")
            if (item.name == "bow") {
                println("You have ${Inventory.CountOfItem(Items.ARROW)}x Arrow left")
            }
            Main().resetEnemyHealth(enemy)
            Thread.sleep(5000)
            Tools().clearScreen()
        } else {
            println("Fight or defend?")
            val input = readLine()!!
            if (input.toLowerCase() == "fight") {
                fight(item, enemy)
            } else if (input.toLowerCase() == "defend") {
                defend(item, enemy)
            } else {
                Tools().OptionNotFound()
                FightOrDefend(item, enemy)
            }
        }
    }
}