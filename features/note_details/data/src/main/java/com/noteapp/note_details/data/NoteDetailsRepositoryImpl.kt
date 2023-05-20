package com.noteapp.note_details.data

import com.noteapp.core.di.IoDispatcher
import com.noteapp.datasource.local.db.NoteDao
import com.noteapp.note_details.domain.NoteDetailsDomainModel
import com.noteapp.note_details.domain.NoteDetailsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NoteDetailsRepositoryImpl @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val dao: NoteDao
) : NoteDetailsRepository {

    override suspend fun upsertNote(noteDetailsDomainModel: NoteDetailsDomainModel) {
        withContext(dispatcher) {
            dao.upsertNote(noteDetailsDomainModel.toNoteEntity())
        }
    }
}