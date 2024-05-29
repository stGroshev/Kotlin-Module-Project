import java.util.Scanner

class NoteHandler(private val scanner: Scanner) {
    fun createNote(): Note? {
        println("Введите название заметки:")
        val title = scanner.nextLine()
        if (title.isEmpty()) {
            println("Название заметки не может быть пустым.")
            return null
        }

        println("Введите содержание заметки:")
        val content = scanner.nextLine()
        if (content.isEmpty()) {
            println("Содержание заметки не может быть пустым.")
            return null
        }

        return Note(title, content)
    }
}

class Note(
    val title: String,
    private val content: String
) {
    fun display() {
        println("Название: $title")
        println("Содержание: $content")
    }
}
