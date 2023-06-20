import trash.sprint_7.BaseStructure.Companion.THE_END
import trash.sprint_7.BaseStructure.Companion.THIS
import java.util.Scanner
fun main() {

    val scan = Scanner(System.`in`)
    val archive = Archive()
    var keyLevel1 = ""
    var keyLevel2 = ""
    var level = "archives"

    while (true) {
        if (level == "archives") {
            archive.showList()
            level = archive.inputHandler(getInput())
            level = when(level) {
                THIS -> "archives"
                THE_END -> break
                else -> { keyLevel1 = level; "notes" }
            }
        }
        if (level == "notes") {
            archive.list.getValue(keyLevel1).showList()
            level = archive.list.getValue(keyLevel1).inputHandler(getInput())
            level = when(level) {
                THIS -> "notes"
                THE_END -> "archives"
                else -> { keyLevel2 = level; "reading" }
            }
        }
        if (level == "reading") {
            println("\n-> ${archive.list.getValue(keyLevel1).list.getValue(keyLevel2)}\nenter, чтобы вернуться")
            if (scan.nextLine().isEmpty()) level = "notes"
        }
    }
    println("Программа завершила работу. До свидания!")
}

fun getInput(): Int {
    val input = Scanner(System.`in`)
    return if (input.hasNextInt()) input.nextInt() else -1
}





