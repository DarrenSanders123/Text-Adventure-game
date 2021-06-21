import Rooms.*
import java.lang.Thread.*
import kotlin.random.Random

enum class Enemies(val att: Int, var hp: Float, val def: Float) {
    GOBLIN(
        att = 1,
        hp = 1f,
        def = 1f
    ), DRAGON(
        att = 30,
        hp = 100f,
        def = 2f
    ), WIZARD(
        att = 20,
        hp = 30f,
        def = 1f
    ), PIG(
        2,
        15f,
        1f
    )
}
enum class Items(val dmg: Int, val dur: Int, val Equipable: Boolean) {
    FIST(
        dmg = 1,
        dur = 99999999,
        Equipable = true
    ), SWORD(
        dmg = 5,
        dur = 25,
        Equipable = true
    ), BOW(
        dmg = 10,
        dur = 20,
        Equipable = true
    ), BUCKET(
        dmg = 0,
        dur = 9999,
        Equipable = false
    ), DAGGER(
        dmg = 6,
        dur = 20,
        Equipable = true
    ), WAND(
        dmg = 20,
        dur = 5,
        Equipable = true
    ), ARROW(
        dmg = 0,
        dur = 9999,
        Equipable = false
    ), BOOK(
        dmg = 0,
        dur = 9999,
        Equipable = false
    ), OP_SWORD(
        dmg = 50,
        dur = 10,
        Equipable = true
    )
}
enum class Rooms() { START(), FIRST(), SECOND(), THIRD(), FORTH(), FIFTH(), SIXTH(), SEVENTH(), EIGHT() }

class Room {
    fun FirstRoom() {
        println("You walked into the first room.\nGo and look around to see if you can find some stuff.(press enter to continue)")
        readLine()!!
        Search().itemDisplay(Items.SWORD)
        println("Wow you found a Sword now you can go and attact enemies.(press enter to continue)")
        readLine()!!
        SecondRoom()
    }
    fun SecondRoom() {
        println("Cool, we entered a new room, kinda dark and creepy here, lets not stay for to long, okey? (press enter to continue)")
        readLine()!!
        println("Lets go look for stuff and go.")
        sleep(1000)
        println("WAIT..........\n" +
                "Whats that?\n")
        sleep(2000)
        println("AAAAAAAAAAAHHHH")
        Search().FoundAEnemy(Enemies.GOBLIN)
        ThirdRoom()
    }
    fun ThirdRoom() {
        println("Oh shit, you killed it good job. thats just nothing compared to whats to come later.........")
        sleep(2000)
        println("I hope your ready to get started.")
        sleep(2000)
        println("Lets go and look for some more items")
        sleep(2000)
        Search().itemDisplay(Items.ARROW)
        println()
        println("Oh nice, some arrows. those will be handy for when you get a bow")
        sleep(2000)
        ForthRoom()
    }
    fun ForthRoom() {
        println("Lets hope we can also find a bow so we can use some of those arrows.")
        sleep(1000)
        println("mmmhm this rooms looks kinda empty, lets just keep looking")
        sleep(3000)
        Search().itemDisplay(Items.ARROW)
        println("Oh nice, some more arrows.")
        Search().itemDisplay(Items.BOW)
        println("Yes a bow, finally. lets keep looking.")
        sleep(2000)
        Search().FoundAEnemy(Enemies.PIG)
        println("yeah good job you killed it.")
        FifthRoom()
    }
    fun FifthRoom() {
        println("the fifth room already, wow you're so good. keep it up")
        sleep(2000)
        println("Lets keep looking around in this stupid place, maybe will find some stuff")
        sleep(2000)
        Search().itemDisplay(Items.BOOK)
        Search().itemDisplay(Items.BOOK)
        println("You found some books cool.(to bad that they dont do anything yet.)")
        sleep(2000)
        Search().FoundAEnemy(Enemies.WIZARD)
        println("You survived that wow. here take some healing")
        sleep(2000)
        Player().HealAll()
        SixthRoom()
    }
    fun SixthRoom() {
        sleep(2000)
        println("WOW, that room was hard i sure hope it won't be any harder.")
        sleep(2000)
        println("Yeah lets keep looking around to find some more stuff because i have a feeling stuff is about to go down.")
        sleep(2000)
        Search().FoundAEnemy(Enemies.PIG)
        sleep(2000)
        println("so hes dead, good. lets keep looking")
        Search().itemDisplay(Items.ARROW)
        Search().itemDisplay(Items.ARROW)
        Search().itemDisplay(Items.ARROW)
        sleep(2000)
        println("some more arrows to kill stuff")
        SeventhRoom()
    }
    fun SeventhRoom() {
        println("almost at the end i can feel it. lets keep going can't stop now")
        sleep(2000)
        Search().FoundAEnemy(enemy = Enemies.GOBLIN)
        sleep(2000)
        println("fuck they keep comming.")
        sleep(2000)
        println("lets go to the next room FAST.")
        sleep(2000)
        println("||you almost fall over this item||")
        sleep(2000)
        println("Hey, whats this.\nYou pick it up")
        sleep(2000)
        Search().itemDisplay(Items.OP_SWORD)
        sleep(2000)
        println("OMG A OP SWORD. SO COOOL")
        sleep(2000)
        EightRoom()
    }
    fun EightRoom() {
        println("the last room, i hope it goes well")
        sleep(2000)
        println("Where oh where is the enemy hiding.")
        sleep(2000)
        println("Whats that sound???")
        sleep(2000)
        Search().FoundAEnemy(Enemies.DRAGON)
        println("pffffew that was a hard fight. i lucky did it.")
        sleep(2000)
        TheEnd()
    }
    fun TheEnd() {
        Tools().clearScreen()
        Main().EndGame("No Message")
        println("thanks for playing my game")
    }

}
