package com.task.noteapp.features.add_note_view_note.common.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.task.noteapp.core.di.IoDispatcher
import com.task.noteapp.features.add_note_view_note.common.data.mapper.toNoteEntity
import com.task.noteapp.features.add_note_view_note.common.db.NoteDatabase
import com.task.noteapp.features.add_note_view_note.common.domain.model.NoteDomainModel
import com.task.noteapp.features.add_note_view_note.common.domain.repository.NoteRepository
import com.task.noteapp.features.add_note_view_note.home.mapper.toNoteDomainModels
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.map
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

    override val notes =
        Pager(config = PagingConfig(
            pageSize = NOTES_PAGING_SIZE,
            enablePlaceholders = false
        ),
            pagingSourceFactory = { dao.getAllNotes() }
        ).flow.map { it.toNoteDomainModels() }

    override suspend fun upsertNote(noteDomainModel: NoteDomainModel) {
        withContext(dispatcher) {
            dao.upsertNote(noteDomainModel.toNoteEntity())
        }
    }

    override suspend fun deleteNote(noteDomainModel: NoteDomainModel) {
        withContext(dispatcher) {
            dao.deleteNote(noteDomainModel.toNoteEntity())
        }
    }
}

private const val NOTES_PAGING_SIZE = 20