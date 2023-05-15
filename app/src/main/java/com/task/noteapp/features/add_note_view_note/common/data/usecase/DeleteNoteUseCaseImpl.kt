package com.task.noteapp.features.add_note_view_note.common.data.usecase

import com.task.noteapp.features.add_note_view_note.common.domain.model.NoteDomainModel
import com.task.noteapp.features.add_note_view_note.common.domain.repository.NoteRepository
import com.task.noteapp.features.add_note_view_note.common.domain.usecase.DeleteNoteUseCase
import javax.inject.Inject

class DeleteNoteUseCaseImpl @Inject constructor(
    private val repository: NoteRepository
) : DeleteNoteUseCase {
    override suspend fun execute(noteDomainModel: NoteDomainModel) =
        repository.deleteNote(noteDomainModel)
}