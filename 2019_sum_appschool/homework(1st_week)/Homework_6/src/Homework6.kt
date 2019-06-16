// Homework6

open class Human {
    open val name = "Sheldon"

    open fun attack(){
        println("${name} use Fist Attack!")
    }
fun mana_power(mana:Int){

}
}

class Mega:Human() {
    val name1 = "jeff"
    val mana = 20
    override fun attack() {
        super.attack()
        println("${name1} use Fireball")
    }

}

fun main(){
   val  human = Human()
   val  mega = Mega()
    mega.attack()
    fun hasmana(obj:Human){
        if(obj is Mega){
            println("You have mana, you can use magic power")
        }else{
            println("Sorry you are human")
        }
    }
    hasmana(mega)
    hasmana(human)
}
