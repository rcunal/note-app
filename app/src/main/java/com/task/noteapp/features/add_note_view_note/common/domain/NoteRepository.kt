package com.task.noteapp.features.add_note_view_note.common.domain

import androidx.paging.PagingData
import com.task.noteapp.features.add_note_view_note.common.domain.model.Note
import kotlinx.coroutines.flow.Flow

/**
 * @author: R. Cemre Ünal,
 * created on 9/22/2022
 */
interface NoteRepository {
    suspend fun addNote(note: Note)
    suspend fun deleteNote(note: Note)
    suspend fun getNotes(): Flow<PagingData<Note>>
}