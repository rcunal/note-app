package com.task.noteapp.features.add_note_view_note.home.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Date

/**
 * @author: R. Cemre Ünal,
 * created on 9/22/2022
 */
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
