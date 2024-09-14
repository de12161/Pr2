fun verifyStr(str:String, alphabet:Array<Char>): Boolean {
    for (char in str) {
        if (!alphabet.contains(char)) return false
    }

    return true
}

fun inputStr(msg:String, alphabet: Array<Char>): String {
    var ret:String

    while (true) {
        print(msg)
        ret = readln()

        if (ret.isEmpty()) {
            println("Строка не может быть пустой")
            continue
        }

        if (!verifyStr(ret, alphabet)) {
            println("Строка должна содержать только эти символы: ")
            alphabet.forEach { print(it) }
            println()
            continue
        }

        return ret
    }
}

fun nonNegMod(x:Int, y:Int): Int {
    return (y + x % y) % y
}

fun encode(str:String, key:String, alphabet: Array<Char>): String {
    var ret = ""

    for (i in str.indices) {
        ret += alphabet[nonNegMod(alphabet.indexOf(str[i]) + alphabet.indexOf(key[nonNegMod(i, key.length)]), alphabet.size)]
    }

    return ret
}

fun decode(str:String, key:String, alphabet: Array<Char>): String {
    var ret = ""

    for (i in str.indices) {
        ret += alphabet[nonNegMod(alphabet.indexOf(str[i]) - alphabet.indexOf(key[nonNegMod(i, key.length)]), alphabet.size)]
    }

    return ret
}

fun main() {
    val alphabet:Array<Char> = Array(32) { (it + 1072).toChar() }

    val mode:Int = inputInt("Введите 1 для шифрования текста или 0 для расшифровки: ", 0, 1)

    val key:String
    val input:String

    if (mode == 1) {
        key = inputStr("Введите ключевое слово: ", alphabet)
        input = inputStr("Введите слово для шифрования: ", alphabet)

        println("Зашифрованный текст: ${encode(input, key, alphabet)}")
    } else if (mode == 0) {
        key = inputStr("Введите ключевое слово: ", alphabet)
        input = inputStr("Введите слово для расшифровки: ", alphabet)

        println("Расшифрованный текст: ${decode(input, key, alphabet)}")
    }
}
