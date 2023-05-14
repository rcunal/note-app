package com.task.noteapp.features.add_note_view_note.common.db

import androidx.paging.PagingSource
import androidx.room.*
import com.task.noteapp.features.add_note_view_note.common.domain.model.Note

/**
 * @author: R. Cemre Ünal,
 * created on 9/21/2022
 */

@Dao
interface NoteDao {

    @Upsert
    suspend fun upsertNote(note: Note)

    @Query("DELETE FROM note")
    suspend fun clearNotes()

    @Delete
    suspend fun deleteNote(model: Note)

    @Query(
        """
        SELECT *
        FROM note
        WHERE LOWER(content) LIKE '%' || LOWER(:query) || '%' OR 
            LOWER(title) LIKE '%' || LOWER(:query)
        """
    )
    fun searchNote(query: String): PagingSource<Int, Note>

    @Query("SELECT * FROM note")
    fun getAllNotes(): PagingSource<Int, Note>
}