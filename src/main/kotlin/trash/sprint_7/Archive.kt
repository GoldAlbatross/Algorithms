import trash.sprint_7.BaseStructure

class Archive: BaseStructure<String, Note>() {

    override var list: MutableMap<String, Note> = mutableMapOf()

    override fun showList() {
        println("\nСписок архивов:\n0. Создать архив")
        super.showList()
    }

    override fun addItem(s: String) {
            if (list.contains(s))  println("элемент с таким названием уже существует!")
            else list[s] = Note()
    }
}