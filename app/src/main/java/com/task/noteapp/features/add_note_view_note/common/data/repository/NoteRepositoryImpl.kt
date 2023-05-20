package com.task.noteapp.features.add_note_view_note.common.data.repository

import com.noteapp.core.di.IoDispatcher
import com.noteapp.datasource.local.db.NoteDao
import com.noteapp.note_details.domain.NoteDetailsDomainModel
import com.noteapp.note_details.domain.NoteDetailsRepository
import com.task.noteapp.features.add_note_view_note.common.data.mapper.toNoteEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @author: R. Cemre Ünal,
 * created on 9/22/2022
 */
class NoteRepositoryImpl @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val dao: NoteDao
) : NoteDetailsRepository {

    override suspend fun upsertNote(noteDetailsDomainModel: NoteDetailsDomainModel) {
        withContext(dispatcher) {
            dao.upsertNote(noteDetailsDomainModel.toNoteEntity())
        }
    }

    override suspend fun deleteNote(noteDetailsDomainModel: NoteDetailsDomainModel) {
        withContext(dispatcher) {
            dao.deleteNote(noteDetailsDomainModel.toNoteEntity())
        }
    }
}