package com.task.noteapp.features.add_note_view_note.common.data.usecase

import com.task.noteapp.features.add_note_view_note.common.domain.model.Note
import com.task.noteapp.features.add_note_view_note.common.domain.repository.NoteRepository
import com.task.noteapp.features.add_note_view_note.common.domain.usecase.SaveNoteUseCase
import java.util.Calendar
import javax.inject.Inject

class SaveNoteUseCaseImpl @Inject constructor(
    private val repository: NoteRepository
) : SaveNoteUseCase {
    override suspend fun execute(params: SaveNoteUseCase.SaveNoteParams) {
        with(params) {
            val currentDate = Calendar.getInstance().time
            val note = Note(
                dbId = noteId ?: 0,
                createDate = createDate ?: currentDate,
                modifyDate = if (isEdited) currentDate else null,
                title = title,
                content = content,
                imageUrl = imageUrl
            )
            repository.upsertNote(note)
        }
    }
}