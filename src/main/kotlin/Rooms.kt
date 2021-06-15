import kotlin.random.Random

enum class Enemies(val att: Int, var hp: Float, val def: Float) {
    GOBLIN(10,1f, 1f), DRAGON(30,100f, 2f), WIZARD(20,30f, 1f)
}

enum class Items(val dmg: Int, val dur: Int, val Equipable: Boolean) {
    FIST(1, 99999999, true), SWORD(5, 25, true), BOW(10, 20, true), BUCKET(0, 9999, false), DAGGER(6, 20, true), WAND(20, 5, true), ARROW(0, 9999, false), BOOK(0, 9999, false)
}

class Rooms {
    fun GenerateRoom() {
        if (Main().GameRunning()) {
            println("You entered the next room what do you want to do? (Search, Next room)")
            val option = readLine()!!
            when {
                option.toLowerCase() == "search" -> {
                    Search().ResetSearches()
                    Search().Search()
                }
                option.toLowerCase() == "next room" -> {
                    Search().ResetSearches()
                    GenerateRoom()
                }
                else -> {
                    Tools().OptionNotFound()
                    GenerateRoom()
                }
            }
        }
    }
}
