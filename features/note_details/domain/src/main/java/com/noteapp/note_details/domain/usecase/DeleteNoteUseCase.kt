package com.noteapp.note_details.domain.usecase

import com.noteapp.note_details.domain.NoteDetailsDomainModel

interface DeleteNoteUseCase {
    suspend fun execute(noteDetailsDomainModel: NoteDetailsDomainModel)
}