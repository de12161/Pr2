fun verifyStr(str:String, alphabet:Array<Char>): Boolean {
    for (char in str) {
        if (!alphabet.contains(char)) return false
    }

    return true
}

fun getStr(msg:String, alphabet: Array<Char>): String {
    var ret:String

    while (true) {
        print(msg)
        ret = readln()

        if (!verifyStr(ret, alphabet)) {
            println("Строка должна содержать только эти символы: ")
            alphabet.forEach { print(it) }
            println()
            continue
        }

        return ret
    }
}

fun myMod(x:Int, y:Int): Int {
    return (y + x % y) % y
}

fun encode(str:String, key:String, alphabet: Array<Char>): String {
    var ret = ""

    for (i in str.indices) {
        ret += alphabet[myMod(alphabet.indexOf(str[i]) + key[myMod(i, key.length)].code, alphabet.size)]
    }

    return ret
}

fun decode(str:String, key:String, alphabet: Array<Char>): String {
    var ret = ""

    for (i in str.indices) {
        ret += alphabet[myMod(alphabet.indexOf(str[i]) - key[myMod(i, key.length)].code, alphabet.size)]
    }

    return ret
}

fun main() {
    val alphabet:Array<Char> = Array(32) { (it + 1072).toChar() }

    val mode:Int = getInt("Введите 1 для шифрования текста или 0 для расшифровки: ", 0, 1)

    val key:String
    val input:String

    if (mode == 1) {
        key = getStr("Введите ключевое слово: ", alphabet)
        input = getStr("Введите слово для шифрования: ", alphabet)

        println("Зашифрованный текст: ${encode(input, key, alphabet)}")
    } else if (mode == 0) {
        key = getStr("Введите ключевое слово: ", alphabet)
        input = getStr("Введите слово для расшифровки: ", alphabet)

        println("Расшифрованный текст: ${decode(input, key, alphabet)}")
    }
}
