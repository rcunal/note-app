package com.task.noteapp.features.add_note_view_note.home.model

import com.task.noteapp.features.add_note_view_note.common.domain.model.Note

/**
 * @author: R. Cemre Ünal,
 * created on 9/22/2022
 */
data class NoteUiModel(val note: Note, val formattedCreateDate: String)
