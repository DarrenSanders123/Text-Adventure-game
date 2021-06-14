class Inventory {
    fun add() {

    }

    fun Remove(Item: Items) {

    }
    fun Show(Item: Items) {

    }

    fun InInventory(item: Items): String {
        return if (inventory.contains(item)) {
            "Available"
        } else {
            "Not Available"
        }
    }

    fun ShowCountOfItem(item: Items): String {
        var count = 0

        for (Item in inventory.toList()) {
            when (Item.name) {
                item.name -> {
                    count++
                    inventory.remove(item)
                }
                else -> continue
            }
        }
        return "${count}x ${item.name}"
    }
    fun CountOfItem(item: Items): Int {
        var count = 0

        for (Item in inventory.toList()) {
            when (Item.name) {
                item.name -> {
                    count++
                    inventory.remove(item)
                }
                else -> continue
            }
        }
        return count
    }
}