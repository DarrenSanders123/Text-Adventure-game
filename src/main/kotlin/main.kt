import javax.swing.KeyStroke
fun clearScreen() {
    print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
}

fun main(args: Array<String>) {
    startMenu()
}

fun startMenu() {
    println("Welcome to our game.\nI hope you don't like it.")

    print("Enter a name: ")
    val username = readLine()!!

    startRoom(username)
}

fun startRoom(username: String) {
    println("This is the Start room, from here you can go and explore the wild.\nPress enter to start!")
    readLine()
    clearScreen()
    MoveToFirstRoom()
}
fun MoveToFirstRoom() {
    GenerateRandomRoom().Room()
}

