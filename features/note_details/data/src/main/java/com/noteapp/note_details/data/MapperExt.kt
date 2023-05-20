package com.noteapp.note_details.data

import com.noteapp.datasource.local.db.NoteEntity
import com.noteapp.note_details.domain.NoteDetailsDomainModel

fun NoteDetailsDomainModel.toNoteEntity() = NoteEntity(
    dbId = id,
    createDate = createDate,
    modifyDate = modifyDate,
    title = title,
    content = content,
    imageUrl = imageUrl
)