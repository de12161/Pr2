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
            println("Число должно быть больше или равно $min")
            continue
        }

        if (ret > max) {
            println("Число должно быть меньше или равно $max")
            continue
        }

        break
    }

    return ret
}

fun print2DArr(arr:Array<Array<Int>>) {
    for (i in arr) {
        for (j in i) {
            print("\t$j")
        }
        println()
    }
}

fun getUniqueDigits(n:Int): MutableSet<Int> {
    val ret:MutableSet<Int> = mutableSetOf()

    for (digit in n.toString()) {
        ret.add(digit.digitToInt())
    }

    return ret
}

fun getUniqueDigits2DArr(arr:Array<Array<Int>>): MutableSet<Int>{
    val ret:MutableSet<Int> = mutableSetOf()

    for (i in arr) {
        for (j in i) {
            ret.addAll(getUniqueDigits(j))
        }
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

    print2DArr(arr)

    println("В массиве использовано ${getUniqueDigits2DArr(arr).size} различных цифр")
}
