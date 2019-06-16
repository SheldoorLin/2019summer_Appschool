// Homework5

 open class Human {
    val name = "Sheldon"
    open fun attack(){
        println("${name} use Fist Attack!")
    }
}

class Mega:Human(){
    val name1 = "Jeff"
    override fun attack() {
        super.attack()
        println("${name1} use Fireball")
    }
}

fun main(){
    val human = Human()
    val mega = Mega()
    mega.attack()
}