package com.noteapp.note_details.domain

/**
 * @author: R. Cemre Ünal,
 * created on 9/22/2022
 */
interface NoteDetailsRepository {
    suspend fun upsertNote(noteDetailsDomainModel: NoteDetailsDomainModel)
    suspend fun deleteNote(noteDetailsDomainModel: NoteDetailsDomainModel)
}