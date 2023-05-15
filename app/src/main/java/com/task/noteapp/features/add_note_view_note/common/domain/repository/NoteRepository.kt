package com.task.noteapp.features.add_note_view_note.common.domain.repository

import androidx.paging.PagingData
import com.task.noteapp.features.add_note_view_note.common.domain.model.NoteDomainModel
import kotlinx.coroutines.flow.Flow

/**
 * @author: R. Cemre Ünal,
 * created on 9/22/2022
 */
interface NoteRepository {
    suspend fun upsertNote(noteDomainModel: NoteDomainModel)
    suspend fun deleteNote(noteDomainModel: NoteDomainModel)
    val notes: Flow<PagingData<NoteDomainModel>>
}