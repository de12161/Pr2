fun getInt(msg:String, min:Int = Int.MIN_VALUE, max:Int = Int.MAX_VALUE): Int {
    var ret:Int

    while (true) {
        try {
            print(msg)
            ret = readln().toInt()
        } catch (e:java.lang.NumberFormatException) {
            println("Неверный ввод")
            continue
        }

        if (ret < min) {
            println("Число должно быть больше $min")
            continue
        }

        if (ret > max) {
            println("Число должно быть меньше $max")
            continue
        }

        break
    }

    return ret
}

fun main() {
    val rows = getInt("Введите количество строк массива: ", 0)
    val cols = getInt("Введите количество столбцов массива: ", 0)
    val arr:Array<Array<Int>> = Array(rows) {
        i -> Array(cols) {
            j -> getInt("[${i + 1}, ${j + 1}] = ")
        }
    }

}