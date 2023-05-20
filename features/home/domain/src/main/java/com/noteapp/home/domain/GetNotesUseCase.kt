package com.noteapp.home.domain

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface GetNotesUseCase {
    fun execute(): Flow<PagingData<NoteDomainModel>>
}