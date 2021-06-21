import java.util.*
import javax.swing.KeyStroke
class Tools {
    fun clearScreen() {
        print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
    }
    fun OptionNotFound() {
        println(message = "Option not found please try again.")
    }
}

fun main() {
    Main().startMenu()
}

class Main {
    private var gameActive = true

    fun startMenu() {
        println(message = "Welcome to our game.\nI hope you don't like it.")
        startRoom()
    }

    private fun startRoom() {
        println(message = "This is the Start room, from here you can go and explore the wild.\nPress enter to start!")
        readLine()
        Tools().clearScreen()
        GoToRoom(rooms = Rooms.FIRST)
    }
    fun GoToRoom(rooms: Rooms) {
        if (gameActive) when (rooms.name) {
            "FIRST" -> Room().FirstRoom()
            "SECOND" -> Room().SecondRoom()
            "THIRD" -> Room().ThirdRoom()
            "FORTH" -> Room().ForthRoom()
            "FIFTH" -> Room().FifthRoom()
            "SIXTH" -> Room().SixthRoom()
            "SEVENTH" -> Room().SeventhRoom()
            "EIGHT" -> Room().EightRoom()
        }
    }


    fun GameRunning(): Boolean {
        return this.gameActive
    }

    fun EndGame(args: String) {
        if (args != "NoMessage") {
            println(message = "Game Over")
        }
        false.also { gameActive = it }
    }

    fun resetEnemyHealth(enemies: Enemies) {
        when (enemies.name) {
            "GOBLIN" -> enemies.hp = 1f
            "DRAGON" -> enemies.hp = 100f
            "WIZARD" -> enemies.hp = 30f
            "PIG" -> enemies.hp = 15f
        }
    }
}




