package com.task.noteapp.features.add_note_view_note.common.data.mapper

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