package com.noteapp.home.domain.usecase

import androidx.paging.PagingData
import com.noteapp.home.domain.NoteDomainModel
import kotlinx.coroutines.flow.Flow

interface GetNotesUseCase {
    fun execute(): Flow<PagingData<NoteDomainModel>>
}