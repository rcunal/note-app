package com.task.noteapp.features.add_note_view_note.common.domain.model

import java.util.Date

data class NoteDomainModel(
    val id: Int = 0,
    val createDate: Date,
    val modifyDate: Date? = null,
    val title: String,
    val content: String? = null,
    val imageUrl: String? = null,
)
