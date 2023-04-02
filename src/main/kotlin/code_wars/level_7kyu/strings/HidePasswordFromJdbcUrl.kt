package code_wars.level_7kyu.strings

/*
We have to create a function that receives a connection string with password included and
you have to mask the password i.e. change password by asterisks.
 */

fun main() {
    println(hidePasswordFromConnection("jdbc:mysql://sdasdasdasd:szdasdasd:dfsdfsdfsdf/sdfsdfsdf?password=12345&user=root"))
    println(hidePasswordFromConnection1("jdbc:mysql://sdasdasdasd:szdasdasd:dfsdfsdfsdf/sdfsdfsdf?password=12345&user=root"))
    println(hidePasswordFromConnection2("jdbc:mysql://sdasdasdasd:szdasdasd:dfsdfsdfsdf/sdfsdfsdf?password=12345&user=root"))
    println(hidePasswordFromConnection3("jdbc:mysql://sdasdasdasd:szdasdasd:dfsdfsdfsdf/sdfsdfsdf?password=12345&user=root"))
    println(hidePasswordFromConnection4("jdbc:mysql://sdasdasdasd:szdasdasd:dfsdfsdfsdf/sdfsdfsdf?password=12345&user=root"))
}
//----------------------------------------------------------------------------------------------------------------------
fun hidePasswordFromConnection(urlString: String): String {
    val startWord = "password="
    return urlString.fold("" to false) { (str,done), it ->
        when {
            done -> str + it to true
            str.contains(startWord) -> { if (it.code == 38) str + it to true else "$str*" to false}
            else -> str + it to false }
    }.first
}
//----------------------------------------------------------------------------------------------------------------------
fun hidePasswordFromConnection1(url: String): String {
    return Regex("(?<=password=)[^&]*").replace(url) { "*".repeat(it.value.length) }
}
//----------------------------------------------------------------------------------------------------------------------
fun hidePasswordFromConnection2(urlString: String): String {
    var password = urlString.substringAfter("password=").substringBefore("&")
    return urlString.replace("$password", "${"*".repeat(password.length)}")
}
//----------------------------------------------------------------------------------------------------------------------
fun hidePasswordFromConnection3(urlString: String): String {
    val regex = Regex("password=([a-zA-Z_0-9'$!]+)")
    val find = regex.find(urlString)
    return urlString.replace(regex, "password=${"*".repeat(find?.groupValues?.get(1)?.count() ?: 0)}")
}
//----------------------------------------------------------------------------------------------------------------------
fun hidePasswordFromConnection4(urlString: String): String {
    val pwd = "password="
    var position = urlString.indexOf(pwd) + pwd.length
    var str = urlString.toCharArray()
    while (position < str.size) {
        if (str[position] == '&') break
        str[position] = '*'
        position++
    }
    return str.joinToString("")
}