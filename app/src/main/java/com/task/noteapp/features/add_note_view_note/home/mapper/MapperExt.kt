package com.task.noteapp.features.add_note_view_note.home.mapper

import androidx.paging.PagingData
import androidx.paging.map
import com.task.noteapp.core.extension.toString
import com.task.noteapp.core.utils.Constant.DATE_FORMAT
import com.task.noteapp.features.add_note_view_note.common.db.NoteEntity
import com.task.noteapp.features.add_note_view_note.common.domain.model.NoteDomainModel
import com.task.noteapp.features.add_note_view_note.home.model.NoteUiModel

/**
 * @author: R. Cemre Ünal,
 * created on 9/22/2022
 */

fun PagingData<NoteDomainModel>.toNoteUiModels() =
    map { note ->
        with(note) {
            NoteUiModel(
                id = id,
                createDate = createDate,
                formattedCreateDate = createDate.toString(DATE_FORMAT),
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