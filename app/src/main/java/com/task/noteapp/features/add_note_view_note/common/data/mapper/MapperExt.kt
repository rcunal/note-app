package com.task.noteapp.features.add_note_view_note.common.data.mapper

import com.task.noteapp.features.add_note_view_note.common.db.NoteEntity
import com.task.noteapp.features.add_note_view_note.common.domain.model.NoteDomainModel

fun NoteDomainModel.toNoteEntity() = NoteEntity(
    dbId = id,
    createDate = createDate,
    modifyDate = modifyDate,
    title = title,
    content = content,
    imageUrl = imageUrl
)