package com.noteapp.note_details.domain

import java.util.Date

data class NoteDetailsDomainModel(
    val id: Int = 0,
    val createDate: Date,
    val modifyDate: Date? = null,
    val title: String,
    val content: String? = null,
    val imageUrl: String? = null,
)
