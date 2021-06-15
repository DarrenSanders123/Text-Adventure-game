class GenerateRandom {
    fun GenerateItem(): Items {
        return Items.values().toList().shuffled().first().let { item ->
            if (item != Items.FIST) return item else GenerateItem()
        }
    }
    fun GenerateEnemy(): Enemies {
        return Enemies.values().toList().shuffled().first()
    }
}