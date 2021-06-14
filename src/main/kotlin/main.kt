import javax.swing.KeyStroke
class Tools {
    fun clearScreen() {
        print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
    }
}
fun main() {
    Main().startMenu()
}
class Main {
    fun startMenu() {
        println("Welcome to our game.\nI hope you don't like it.")

        print("Enter a name: ")
        val username = readLine()!!
        startRoom(username)
    }

    fun startRoom(username: String) {
        println("This is the Start room, from here you can go and explore the wild.\nPress enter to start!")
        readLine()
        Tools().clearScreen()
        Inventory.AddItem(Items.FIST)
        MoveToNextRoom()
    }
    fun MoveToNextRoom() {
        Rooms().GenerateRoom()
    }
    fun OptionNotFound() {
        println("Option not found please try again.")
    }
    fun EndGame() {

    }
}




