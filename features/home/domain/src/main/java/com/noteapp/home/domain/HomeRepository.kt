package com.noteapp.home.domain

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    val notes: Flow<PagingData<NoteDomainModel>>
}