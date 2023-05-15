package com.task.noteapp.features.add_note_view_note.common.domain.usecase

import androidx.paging.PagingData
import com.task.noteapp.features.add_note_view_note.common.domain.model.NoteDomainModel
import kotlinx.coroutines.flow.Flow

interface GetNotesUseCase {
    fun execute(): Flow<PagingData<NoteDomainModel>>
}