package com.task.noteapp.features.add_note_view_note.common.data.repository

import com.noteapp.core.IoDispatcher
import com.noteapp.datasource.local.db.NoteDao
import com.task.noteapp.features.add_note_view_note.common.data.mapper.toNoteEntity
import com.task.noteapp.features.add_note_view_note.common.domain.model.NoteDomainModel
import com.task.noteapp.features.add_note_view_note.common.domain.repository.NoteRepository
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
) : NoteRepository {

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