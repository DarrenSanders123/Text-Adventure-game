import java.util.*
import javax.swing.KeyStroke
class Tools {
    fun clearScreen() {
        print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
    }
    fun OptionNotFound() {
        println("Option not found please try again.")
    }
}

fun main() {
    Main().startMenu()
}

class Main {
    private var gameActive = true

    fun startMenu() {
        println("Welcome to our game.\nI hope you don't like it.")
        startRoom()
    }

    private fun startRoom() {
        println("This is the Start room, from here you can go and explore the wild.\nPress enter to start!")
        readLine()
        Tools().clearScreen()
        Inventory.AddItem(Items.FIST)
        MoveToNextRoom()
    }
    private fun MoveToNextRoom() {
        if (gameActive) Rooms().GenerateRoom()
    }

    fun GameRunning(): Boolean {
        return gameActive
    }

    fun EndGame() {
        println("Game Over")
        gameActive = false
    }
}




