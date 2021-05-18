import kotlin.random.Random

class GenerateRandomItem {
    fun Generate(): Items {
        val item = Items.values().toList().shuffled().first()
        return item
    }
}