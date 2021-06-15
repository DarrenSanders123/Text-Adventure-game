class Inventory {
    fun add() {

    }

    fun RemoveItem(item: Items) {
        inventory.remove(item)
    }
    fun Show(Item: Items) {

    }

    fun InInventory(item: Items): String {
        return if (inventory.contains(item)) "Available" else "Not Available"
    }

    fun ShowCountOfItem(item: Items): String {
        return "${inventory.filter { it == item }.size}x ${item.name}"
    }
    fun CountOfItem(item: Items): Int {
        return inventory.filter { it == item }.size
    }

}