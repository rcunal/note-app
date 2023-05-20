package com.noteapp.home.data

import androidx.paging.PagingData
import androidx.paging.map
import com.noteapp.datasource.local.db.NoteEntity
import com.noteapp.home.domain.NoteDomainModel

fun PagingData<NoteEntity>.toNoteDomainModels() =
    map { note ->
        with(note) {
            NoteDomainModel(
                id = dbId,
                createDate = createDate,
                modifyDate = modifyDate,
                title = title,
                content = content,
                imageUrl = imageUrl
            )
        }
    }

fun NoteDomainModel.toNoteEntity() = NoteEntity(
    dbId = id,
    createDate = createDate,
    modifyDate = modifyDate,
    title = title,
    content = content,
    imageUrl = imageUrl
)