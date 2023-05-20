package com.noteapp.home.domain.usecase

import com.noteapp.home.domain.NoteDomainModel

interface DeleteNoteUseCase {
    suspend fun execute(noteDomainModel: NoteDomainModel)
}