package com.task.noteapp.features.add_note_view_note.home.mapper

import androidx.paging.PagingData
import androidx.paging.map
import com.task.noteapp.features.add_note_view_note.common.domain.model.Note
import com.task.noteapp.core.extension.toString
import com.task.noteapp.core.utils.Constant.DATE_FORMAT
import com.task.noteapp.features.add_note_view_note.home.model.NoteUiModel

/**
 * @author: R. Cemre Ünal,
 * created on 9/22/2022
 */

fun PagingData<Note>.toNoteUiModels() =
    map { note ->
        NoteUiModel(
            note = note, formattedCreateDate = note.createDate.toString(DATE_FORMAT)
        )
    }