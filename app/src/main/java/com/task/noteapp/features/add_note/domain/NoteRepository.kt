package com.task.noteapp.features.add_note.domain

import androidx.paging.PagingData
import com.task.noteapp.core.db.Note
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