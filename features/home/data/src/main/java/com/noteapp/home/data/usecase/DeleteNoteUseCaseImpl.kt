package com.noteapp.home.data.usecase

import com.noteapp.home.domain.HomeRepository
import com.noteapp.home.domain.NoteDomainModel
import com.noteapp.home.domain.usecase.DeleteNoteUseCase
import javax.inject.Inject

class DeleteNoteUseCaseImpl @Inject constructor(
    private val repository: HomeRepository
) : DeleteNoteUseCase {
    override suspend fun execute(noteDomainModel: NoteDomainModel) =
        repository.deleteNote(noteDomainModel)
}