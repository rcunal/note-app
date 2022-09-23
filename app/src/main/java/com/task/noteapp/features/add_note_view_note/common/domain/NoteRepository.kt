package com.task.noteapp.features.add_note_view_note.common.domain

import androidx.paging.PagingSource
import com.task.noteapp.features.add_note_view_note.common.domain.model.Note

/**
 * @author: R. Cemre Ünal,
 * created on 9/22/2022
 */
interface NoteRepository {
    suspend fun addNote(note: Note)
    suspend fun deleteNote(note: Note)
    fun getNotes(): PagingSource<Int, Note>
}