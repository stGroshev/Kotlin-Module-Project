import java.util.Scanner

class Archive(val name: String, private val scanner: Scanner) {
    private val notes = mutableListOf<Note>()

    fun addNote() {
        val noteHandler = NoteHandler(scanner)
        val note = noteHandler.createNote()
        if (note != null) {
            notes.add(note)
            println("Заметка \"${note.title}\" добавлена в архив \"$name\".")
        }
    }

    fun listNotes() {
        if (notes.isEmpty()) {
            println("В архиве \"$name\" пока нет заметок.")
            return
        }

        val menuHandler = MenuHandler(scanner)
        val noteOptions = notes.mapIndexed { index, note -> "${index + 1}. ${note.title}" to { note.display() } }
        menuHandler.showMenu(noteOptions, "Назад")
    }
}
