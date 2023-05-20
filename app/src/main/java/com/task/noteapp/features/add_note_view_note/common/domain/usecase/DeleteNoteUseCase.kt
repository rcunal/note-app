package com.task.noteapp.features.add_note_view_note.common.domain.usecase

import com.task.noteapp.features.add_note_view_note.common.domain.model.NoteDomainModel

interface DeleteNoteUseCase {
    suspend fun execute(noteDomainModel: NoteDomainModel)
}