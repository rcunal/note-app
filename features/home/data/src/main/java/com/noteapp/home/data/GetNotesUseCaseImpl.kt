package com.noteapp.home.data

import androidx.paging.PagingData
import com.noteapp.home.domain.GetNotesUseCase
import com.noteapp.home.domain.HomeRepository
import com.noteapp.home.domain.NoteDomainModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNotesUseCaseImpl @Inject constructor(
    private val repository: HomeRepository
) : GetNotesUseCase {
    override fun execute(): Flow<PagingData<NoteDomainModel>> = repository.notes
}