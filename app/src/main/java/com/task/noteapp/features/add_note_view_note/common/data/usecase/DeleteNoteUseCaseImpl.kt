package com.task.noteapp.features.add_note_view_note.common.data.usecase

import com.task.noteapp.features.add_note_view_note.common.domain.model.Note
import com.task.noteapp.features.add_note_view_note.common.domain.repository.NoteRepository
import com.task.noteapp.features.add_note_view_note.common.domain.usecase.DeleteNoteUseCase
import javax.inject.Inject

class DeleteNoteUseCaseImpl @Inject constructor(
    private val repository: NoteRepository
) : DeleteNoteUseCase {
    override suspend fun execute(note: Note) = repository.deleteNote(note)
}