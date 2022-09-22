package com.task.noteapp.features.home.model

import com.task.noteapp.core.db.Note

/**
 * @author: R. Cemre Ünal,
 * created on 9/22/2022
 */
data class NoteUiModel(val note: Note, val formattedCreateDate: String)
