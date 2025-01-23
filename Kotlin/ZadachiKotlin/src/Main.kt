import kotlin.math.pow

fun main() {
    // 1. Функция для нахождения максимума
    println("Задание 1")
    try {
        println("Максимум: ${maxOfTwo(3, 5)}") // Ожидается 5
        println("Максимум: ${maxOfTwo(4, 4)}") // Ошибка
    } catch (e: IllegalArgumentException) {
        println("Ошибка: ${e.message}")
    }

    // 2. Калькулятор деления
    println("Задание 2")
    try {
        println("Деление: ${divide(10.0, 2.0)}") // Ожидается 5.0
        println("Деление: ${divide(10.0, 0.0)}") // Ошибка
    } catch (e: ArithmeticException) {
        println("Ошибка: ${e.message}")
    }

    // 3. Конвертер строк в числа
    println("Задание 3")
    try {
        println("Конвертация: ${stringToInt("123")}") // Ожидается 123
        println("Конвертация: ${stringToInt("abc")}") // Ошибка
    } catch (e: NumberFormatException) {
        println("Ошибка: ${e.message}")
    }

    // 4. Проверка возраста
    println("Задание 4")
    try {
        validateAge(25) // Ожидается нормальная работа
        validateAge(-5) // Ошибка
    } catch (e: IllegalArgumentException) {
        println("Ошибка: ${e.message}")
    }

    // 5. Нахождение корня
    println("Задание 5")
    try {
        println("Корень: ${sqrt(16.0)}") // Ожидается 4.0
        println("Корень: ${sqrt(-1.0)}") // Ошибка
    } catch (e: IllegalArgumentException) {
        println("Ошибка: ${e.message}")
    }

    // 6. Факториал
    println("Задание 6")
    try {
        println("Факториал: ${factorial(5)}") // Ожидается 120
        println("Факториал: ${factorial(-3)}") // Ошибка
    } catch (e: IllegalArgumentException) {
        println("Ошибка: ${e.message}")
    }

    // 7. Проверка массива на нули
    println("Задание 7")
    try {
        checkForZeros(intArrayOf(1, 2, 3)) // Ожидается нормальная работа
        checkForZeros(intArrayOf(0, 1, 2)) // Ошибка
    } catch (e: IllegalArgumentException) {
        println("Ошибка: ${e.message}")
    }

    // 8. Калькулятор возведения в степень
    println("Задание 8")
    try {
        println("Степень: ${power(2.0, 3)}") // Ожидается 8.0
        println("Степень: ${power(2.0, -1)}") // Ошибка
    } catch (e: IllegalArgumentException) {
        println("Ошибка: ${e.message}")
    }

    // 9. Обрезка строки
    println("Задание 9")
    try {
        println("Обрезанная строка: ${truncateString("Hello, Kotlin!", 5)}") // Ожидается "Hello"
        println("Обрезанная строка: ${truncateString("Hi", 5)}") // Ошибка
    } catch (e: IllegalArgumentException) {
        println("Ошибка: ${e.message}")
    }

    // 10. Поиск элемента в массиве
    println("Задание 10")
    try {
        println("Индекс элемента: ${findElement(intArrayOf(1, 2, 3), 2)}") // Ожидается 1
        println("Индекс элемента: ${findElement(intArrayOf(1, 2, 3), 5)}") // Ошибка
    } catch (e: NoSuchElementException) {
        println("Ошибка: ${e.message}")
    }

    // 11. Конвертация в двоичную систему
    println("Задание 11")
    try {
        println("Двоичное представление: ${toBinaryString(10)}") // Ожидается "1010"
        println("Двоичное представление: ${toBinaryString(-1)}") // Ошибка
    } catch (e: IllegalArgumentException) {
        println("Ошибка: ${e.message}")
    }

    // 12. Проверка делимости
    println("Задание 12")
    try {
        println("Делимость: ${isDivisible(10, 2)}") // Ожидается true
        println("Делимость: ${isDivisible(10, 0)}") // Ошибка
    } catch (e: ArithmeticException) {
        println("Ошибка: ${e.message}")
    }

    // 13. Чтение элемента списка
    println("Задание 13")
    try {
        val list = listOf("A", "B", "C")
        println("Элемент списка: ${getElementAt(list, 1)}") // Ожидается "B"
        println("Элемент списка: ${getElementAt(list, 5)}") // Ошибка
    } catch (e: IndexOutOfBoundsException) {
        println("Ошибка: ${e.message}")
    }

    // 14. Парольная проверка
    println("Задание 14")
    try {
        checkPassword("strongpass") // Ожидается нормальная работа
        checkPassword("weak") // Ошибка
    } catch (e: IllegalArgumentException) {
        println("Ошибка: ${e.message}")
    }

    // 15. Проверка даты
    println("Задание 15")
    try {
        validateDate("25.12.2025") // Ожидается нормальная работа
        validateDate("2025/12/25") // Ошибка
    } catch (e: IllegalArgumentException) {
        println("Ошибка: ${e.message}")
    }

    // 16. Конкатенация строк
    println("Задание 16")
    try {
        println("Конкатенация: ${concatenateStrings("Hello, ", "World!")}") // Ожидается "Hello, World!"
        println("Конкатенация: ${concatenateStrings(null, "World!")}") // Ошибка
    } catch (e: NullPointerException) {
        println("Ошибка: ${e.message}")
    }

    // 17. Остаток от деления
    println("Задание 17")
    try {
        println("Остаток: ${modulo(10, 3)}") // Ожидается 1
        println("Остаток: ${modulo(10, 0)}") // Ошибка
    } catch (e: ArithmeticException) {
        println("Ошибка: ${e.message}")
    }

    // 18. Квадратный корень
    println("Задание 18")
    try {
        println("Квадратный корень: ${squareRoot(9.0)}") // Ожидается 3.0
        println("Квадратный корень: ${squareRoot(-9.0)}") // Ошибка
    } catch (e: IllegalArgumentException) {
        println("Ошибка: ${e.message}")
    }

    // 19. Конвертер температуры
    println("Задание 19")
    try {
        println("Температура: ${celsiusToFahrenheit(0.0)}") // Ожидается 32.0
        println("Температура: ${celsiusToFahrenheit(-300.0)}") // Ошибка
    } catch (e: IllegalArgumentException) {
        println("Ошибка: ${e.message}")
    }

    // 20. Проверка строки на пустоту
    println("Задание 20")
    try {
        validateString("Kotlin!") // Ожидается нормальная работа
        validateString("") // Ошибка
    } catch (e: IllegalArgumentException) {
        println("Ошибка: ${e.message}")
    }
}

fun maxOfTwo(a: Int, b: Int): Int {
    if (a == b) throw IllegalArgumentException("Числа равны")
    return if (a > b) a else b
}

fun divide(a: Double, b: Double): Double {
    if (b == 0.0) throw ArithmeticException("Деление на ноль недопустимо")
    return a / b
}

fun stringToInt(input: String): Int {
    return input.toIntOrNull() ?: throw NumberFormatException("Неверный формат числа")
}

fun validateAge(age: Int) {
    if (age < 0 || age > 150) throw IllegalArgumentException("Возраст должен быть в диапазоне от 0 до 150")
}

fun sqrt(value: Double): Double {
    if (value < 0) throw IllegalArgumentException("Невозможно вычислить корень из отрицательного числа")
    return kotlin.math.sqrt(value)
}

fun factorial(n: Int): Long {
    if (n < 0) throw IllegalArgumentException("Факториал не определён для отрицательных чисел")
    return if (n == 0) 1 else n * factorial(n - 1)
}

fun checkForZeros(array: IntArray) {
    if (array.contains(0)) throw IllegalArgumentException("Массив содержит нули")
}

fun power(base: Double, exponent: Int): Double {
    if (exponent < 0) throw IllegalArgumentException("Отрицательная степень не поддерживается")
    return base.pow(exponent)
}

fun truncateString(input: String, length: Int): String {
    if (length > input.length) throw IllegalArgumentException("Длина больше длины строки")
    return input.substring(0, length)
}

fun findElement(array: IntArray, element: Int): Int {
    return array.indexOf(element).takeIf { it >= 0 } ?: throw NoSuchElementException("Элемент не найден")
}

fun toBinaryString(number: Int): String {
    if (number < 0) throw IllegalArgumentException("Число не должно быть отрицательным")
    return Integer.toBinaryString(number)
}

fun isDivisible(a: Int, b: Int): Boolean {
    if (b == 0) throw ArithmeticException("Деление на ноль недопустимо")
    return a % b == 0
}

fun getElementAt(list: List<Any>, index: Int): Any {
    if (index !in list.indices) throw IndexOutOfBoundsException("Индекс выходит за пределы списка")
    return list[index]
}

fun checkPassword(password: String) {
    if (password.length < 8) throw IllegalArgumentException("Пароль слишком короткий")
}

fun validateDate(date: String) {
    val regex = Regex("""\d{2}\.\d{2}\.\d{4}""")
    if (!regex.matches(date)) throw IllegalArgumentException("Неверный формат даты, используйте формат dd.MM.yyyy")
}

fun concatenateStrings(str1: String?, str2: String?): String {
    if (str1 == null || str2 == null) throw NullPointerException("Одна из строк равна null")
    return str1 + str2
}

fun modulo(a: Int, b: Int): Int {
    if (b == 0) throw ArithmeticException("Деление на ноль недопустимо")
    return a % b
}

fun squareRoot(value: Double): Double {
    if (value < 0) throw IllegalArgumentException("Невозможно вычислить квадратный корень из отрицательного числа")
    return kotlin.math.sqrt(value)
}

fun celsiusToFahrenheit(celsius: Double): Double {
    if (celsius < -273.15) throw IllegalArgumentException("Температура не может быть ниже абсолютного нуля")
    return celsius * 9 / 5 + 32
}

fun validateString(input: String?) {
    if (input.isNullOrEmpty()) {
        throw IllegalArgumentException("Строка пустая или равна null")
    } else println("Строка не пустая")
}
