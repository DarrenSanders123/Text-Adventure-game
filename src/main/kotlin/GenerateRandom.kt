class GenerateRandom {
    fun GenerateItem(): Items {
        val item = Items.values().toList().shuffled().first()
            if (item != Items.FIST) {
                return item
            } else {
                GenerateItem()
            }
        return item
    }
    fun GenerateEnemy(): Enemies {
        return Enemies.values().toList().shuffled().first()
    }
}