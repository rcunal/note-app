package com.task.noteapp.features.add_note.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.task.noteapp.core.db.Note
import com.task.noteapp.core.db.NoteDatabase
import com.task.noteapp.features.add_note.domain.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author: R. Cemre Ünal,
 * created on 9/22/2022
 */

@Singleton
class NoteRepositoryImpl @Inject constructor(
    private val dispatchers: Dispatchers,
    db: NoteDatabase
) : NoteRepository {

    private val dao = db.noteDao

    override suspend fun addNote(note: Note) {
        withContext(dispatchers.IO) {
            dao.insertNote(note)
        }
    }

    override suspend fun deleteNote(note: Note) {
        withContext(dispatchers.IO) {
            dao.deleteNote(note)
        }
    }

    override suspend fun getNotes(): Flow<PagingData<Note>> {
        return Pager(
            PagingConfig(
                pageSize = 20,
                initialLoadSize = 10,
                maxSize = 100,
                enablePlaceholders = false
            )
        ) {
            dao.getAllNotes()
        }.flow.flowOn(dispatchers.IO)
    }
}