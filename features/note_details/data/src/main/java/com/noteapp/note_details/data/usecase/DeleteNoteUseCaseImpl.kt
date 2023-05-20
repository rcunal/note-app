package com.noteapp.note_details.data.usecase

import com.noteapp.note_details.domain.NoteDetailsDomainModel
import com.noteapp.note_details.domain.NoteDetailsRepository
import com.noteapp.note_details.domain.usecase.DeleteNoteUseCase
import javax.inject.Inject

class DeleteNoteUseCaseImpl @Inject constructor(
    private val repository: NoteDetailsRepository
) : DeleteNoteUseCase {
    override suspend fun execute(noteDetailsDomainModel: NoteDetailsDomainModel) =
        repository.deleteNote(noteDetailsDomainModel)
}