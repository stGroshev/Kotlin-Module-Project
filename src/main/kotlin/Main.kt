import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val menuHandler = MenuHandler(scanner)
    val archives = mutableListOf<Archive>()

    while (true) {
        val archiveOptions = mutableListOf<Pair<String, () -> Unit>>(
            "Создать архив" to {
                println("Введите название архива:")
                val name = scanner.nextLine()
                if (name.isNotEmpty()) {
                    archives.add(Archive(name, scanner))
                    println("Архив \"$name\" создан.")
                } else {
                    println("Название архива не может быть пустым.")
                }
            }
        )
        archives.forEachIndexed { index, archive ->
            archiveOptions.add("${index + 1}. ${archive.name}" to {
                menuHandler.showMenu(
                    listOf(
                        "Создать заметку" to { archive.addNote() },
                        "Просмотреть заметки" to { archive.listNotes() }
                    ),
                    "Назад"
                )
            })
        }

        println("0. Создать архив")
        for ((i, archive) in archives.withIndex()) {
            println("${i + 1}. ${archive.name}")
        }
        println("${archives.size + 1}. Выход")

        val input = scanner.nextLine()
        val choice = input.toIntOrNull()

        if (choice == null) {
            println("Следует вводить цифру.")
        } else if (choice == 0) {
            archiveOptions[0].second.invoke()
        } else if (choice in 1..archives.size) {
            archiveOptions[choice].second.invoke()
        } else if (choice == archives.size + 1) {
            break
        } else {
            println("Такой цифры нет. Введите корректный символ.")
        }
    }
}

