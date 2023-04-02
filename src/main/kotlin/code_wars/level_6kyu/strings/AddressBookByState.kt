package code_wars.level_6kyu.strings


fun main() {
    val a = "John Daggett, 341 King Road, Plymouth MA\n" +
            "Alice Ford, 22 East Broadway, Richmond VA\n" +
            "Orville Thomas, 11345 Oak Bridge Road, Tulsa OK\n" +
            "Terry Kalkas, 402 Lans Road, Beaver Falls PA\n" +
            "Eric Adams, 20 Post Road, Sudbury MA\n" +
            "Hubert Sims, 328A Brook Road, Roanoke MA\n" +
            "Amy Wilde, 334 Bayshore Pkwy, Mountain View CA\n" +
            "Sal Carpenter, 73 6th Street, Boston MA"
    //println(State.byState(a))
    println(State2.byState(a))

}


object State {
    private val stateList = arrayListOf("AZ","CA","ID","IN","MA","OK","PA","VA")
    private val map = hashMapOf<String, ArrayList<String>>()

    private var isFirst = true

    fun byState(str: String): String {
        var regex = """(\n)""".toRegex()
        val list = arrayListOf<String>()
        val result = StringBuilder()
        list.addAll(str.filter { it != ',' }.split(regex))

        for (item in stateList) {
            regex = item.toRegex()
            val tempList = arrayListOf<String>()
            for (it in list) {
                if (it.contains(regex)) {
                    val s = it.replace(item, findState(item))
                    tempList.add(s)
                }
            }
            tempList.sortBy { it.firstWord }
            map[item] = tempList

            if (!map[item].isNullOrEmpty()) addNewState(item, result)

        }
        map.clear()
        isFirst = true
        return result.toString()
    }

    private fun addNewState(item: String, result: StringBuilder) {
        if (isFirst) {
            isFirst = false
        } else result.append("\n ")
        result.append(findState(item))
        map[item]?.forEach { result.append("\n..... $it") }
    }

    private val String.firstWord: String
        get() = this.takeWhile { it != ' ' }

    private fun findState(str: String): String {
        return when (str) {
            stateList[0] -> "Arizona"
            stateList[1] -> "California"
            stateList[2] -> "Idaho"
            stateList[3] -> "Indiana"
            stateList[4] -> "Massachusetts"
            stateList[5] -> "Oklahoma"
            stateList[6] -> "Pennsylvania"
            stateList[7] -> "Virginia"
            else -> ""
        }
    }
}
//======================================================================================================================
object State2 {
    private val mapState = mapOf(
        "AZ" to "Arizona",
        "CA" to "California",
        "ID" to "Idaho",
        "IN" to "Indiana",
        "MA" to "Massachusetts",
        "OK" to "Oklahoma",
        "PA" to "Pennsylvania",
        "VA" to "Virginia"
    )
    fun byState(str: String): String {
        val statesGroup = str
            .split("\n")
            .groupBy({ mapState[it.takeLast(2)] }, { it })

        return statesGroup.map { item ->
            "${item.key}" + item.value.sorted().joinToString(
                "\n..... ",
                "\n..... "
            ) { "${it.split(',').joinToString("").dropLast(2)}${mapState[it.takeLast(2)]}" }
        }.sorted().joinToString("\n ")
    }
}
//======================================================================================================================





