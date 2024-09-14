fun inputInt(msg:String, min:Int? = null, max:Int? = null): Int {
    var ret:Int?

    while (true) {
        print(msg)
        ret = readln().toIntOrNull()

        if (ret == null) {
            println("Неверный ввод")
            continue
        }

        if (min != null && ret < min) {
            println("Число должно быть больше или равно $min")
            continue
        }

        if (max != null && ret > max) {
            println("Число должно быть меньше или равно $max")
            continue
        }

        return ret
    }
}

fun getUniqueDigits(n:Int): Set<Int> {
    val ret:MutableSet<Int> = mutableSetOf()

    for (digit in n.toString()) {
        ret.add(digit.digitToInt())
    }

    return ret
}

fun getUniqueDigits2DArr(arr:Array<Array<Int>>): Set<Int>{
    val ret:MutableSet<Int> = mutableSetOf()

    for (i in arr) {
        for (j in i) {
            ret.addAll(getUniqueDigits(j))
        }
    }

    return ret
}

fun main() {
    val rows = inputInt("Введите количество строк массива: ", 0)
    val cols = inputInt("Введите количество столбцов массива: ", 0)

    val arr:Array<Array<Int>> = Array(rows) {
        i -> Array(cols) {
            j -> inputInt("[${i + 1}, ${j + 1}] = ")
        }
    }

    arr.forEach {
        row -> row.forEach { print("\t$it") }
        println()
    }

    println("В массиве использовано ${getUniqueDigits2DArr(arr).size} различных цифр(ы)")
}
