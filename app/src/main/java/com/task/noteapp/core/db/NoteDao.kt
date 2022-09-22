package com.task.noteapp.core.db

import androidx.paging.PagingSource
import androidx.room.*

/**
 * @author: R. Cemre Ünal,
 * created on 9/21/2022
 */

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Query("DELETE FROM note")
    suspend fun clearNotes()

    @Delete
    fun deleteNote(model: Note)

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