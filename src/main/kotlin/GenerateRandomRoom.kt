import kotlin.random.Random

enum class Enemies(val att: Int, val hp: Int) {
    GOBLIN(10,1), DRAGON(30,100), WIZARD(20,30)
}

enum class Items(val dmg: Int, val dur: Int, val Equipable: Boolean) {
    SWORD(5, 25, true), BOW(10, 20, true), BUCKET(0, 9999, false), DAGGER(6, 20, true), WAND(20, 5, true), ARROW(0, 9999, false), BOOK(0, 9999, false)
}


class GenerateRandomRoom {
    private fun GenerateEnemy(): Enemies {
        return Enemies.values().toList().shuffled().first()
    }

    fun GenerateRoom() {

    }

    fun Room() {
        val spawn = Random.nextInt(1,4)
        if (spawn == 3) {
            GenerateEnemy()
        }
    }
}
