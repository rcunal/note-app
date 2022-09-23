package com.task.noteapp.features.add_note_view_note.common.data

import androidx.paging.PagingSource
import com.task.noteapp.features.add_note_view_note.common.db.NoteDatabase
import com.task.noteapp.features.add_note_view_note.common.domain.NoteRepository
import com.task.noteapp.features.add_note_view_note.common.domain.model.Note
import kotlinx.coroutines.Dispatchers
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

    override fun getNotes(): PagingSource<Int, Note> {
        return dao.getAllNotes()
    }
}