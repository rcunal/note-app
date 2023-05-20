package com.noteapp.home.domain

import java.util.Date

data class NoteDomainModel(
    val id: Int = 0,
    val createDate: Date,
    val modifyDate: Date? = null,
    val title: String,
    val content: String? = null,
    val imageUrl: String? = null,
)
