fun getUniqueChars(str:String): Set<Char> {
    val ret:MutableSet<Char> = mutableSetOf()

    for (char in str) {
        ret.add(char)
    }

    return ret
}

fun getGroup(chars:Set<Char>, arr:List<String>): List<String> {
    val ret:MutableList<String> = mutableListOf()

    for (str in arr) {
        if (getUniqueChars(str) == chars) ret.add(str)
    }

    return ret
}

fun main() {
    println("Введите любое количество слов: ")
    val input = readln().split(" ")

    val groups:MutableSet<List<String>> = mutableSetOf()
    for (str in input) {
        groups.add(getGroup(getUniqueChars(str), input))
    }

    println("Группы слов, состоящих из одинаковых букв: ")
    for (group in groups) {
        for (word in group) {
            print(" $word")
        }
        println()
    }
}
