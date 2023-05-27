package com.noteapp.note_details.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class NoteUiModel(
    val id: Int = 0,
    val createDate: Date,
    val formattedCreateDate: String,
    val modifyDate: Date? = null,
    val title: String,
    val content: String? = null,
    val imageUrl: String? = null
) : Parcelable
