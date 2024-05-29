import java.util.Scanner

class MenuHandler(private val scanner: Scanner) {
    fun showMenu(options: List<Pair<String, () -> Unit>>, exitOption: String = "Выход"): Boolean {
        while (true) {
            for (i in options.indices) {
                println("${i}. ${options[i].first}")
            }
            println("${options.size}. $exitOption")

            val input = scanner.nextLine()
            val choice = input.toIntOrNull()

            if (choice == null) {
                println("Следует вводить цифру.")
                continue
            }

            if (choice in options.indices) {
                options[choice].second.invoke()
            } else if (choice == options.size) {
                return false
            } else {
                println("Такой цифры нет. Введите корректный символ.")
            }
        }
    }
}
