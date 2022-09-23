package com.task.noteapp.features.add_note_view_note.common.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.util.*

/**
 * @author: R. Cemre Ünal,
 * created on 9/21/2022
 */

@Parcelize
@Entity
data class Note(
    @PrimaryKey(autoGenerate = true)
    val dbId: Int = 0,
    val createDate: Date,
    val modifyDate: Date? = null,
    val title: String,
    val content: String? = null,
    val imageUrl: String? = null,
) : Parcelable
