import trash.sprint_7.BaseStructure

class Note: BaseStructure<String, String>() {

    override var list: MutableMap<String, String> = mutableMapOf()

    override fun showList() {
        println("\nСписок заметок:\n0. Создать заметку")
        super.showList()
    }

    override fun addItem(s: String) {
        if (list.contains(s)) println("элемент с таким названием уже существует!")
        else { println("Введите текст заметки"); list[s] = scan.nextLine() }
    }
}