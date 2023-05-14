package com.task.noteapp.features.add_note_view_note.common.data.repository

import androidx.paging.PagingSource
import com.task.noteapp.core.di.IoDispatcher
import com.task.noteapp.features.add_note_view_note.common.db.NoteDatabase
import com.task.noteapp.features.add_note_view_note.common.domain.repository.NoteRepository
import com.task.noteapp.features.add_note_view_note.common.domain.model.Note
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @author: R. Cemre Ünal,
 * created on 9/22/2022
 */
class NoteRepositoryImpl @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    db: NoteDatabase
) : NoteRepository {

    private val dao = db.noteDao

    override suspend fun upsertNote(note: Note) {
        withContext(dispatcher) {
            dao.upsertNote(note)
        }
    }

    override suspend fun deleteNote(note: Note) {
        withContext(dispatcher) {
            dao.deleteNote(note)
        }
    }

    override fun getNotes(): PagingSource<Int, Note> {
        return dao.getAllNotes()
    }
}