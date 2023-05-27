package com.noteapp.home.ui

import androidx.paging.PagingData
import androidx.paging.map
import com.noteapp.core.domain.toStringWithFormat
import com.noteapp.home.domain.Constants.DATE_FORMAT
import com.noteapp.home.domain.NoteDomainModel
import com.noteapp.home.ui.model.NoteUiModel

fun PagingData<NoteDomainModel>.toNoteUiModels() =
    map { note ->
        with(note) {
            NoteUiModel(
                id = id,
                createDate = createDate,
                formattedCreateDate = createDate.toStringWithFormat(DATE_FORMAT),
                modifyDate = modifyDate,
                title = title,
                content = content,
                imageUrl = imageUrl
            )
        }
    }

fun NoteUiModel.toNoteDomainModel() = NoteDomainModel(
    id = id,
    createDate = createDate,
    modifyDate = modifyDate,
    title = title,
    content = content,
    imageUrl = imageUrl
)