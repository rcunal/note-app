package com.task.noteapp.features.add_note_view_note.common.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

/**
 * @author: R. Cemre Ünal,
 * created on 9/21/2022
 */

@Entity
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val dbId: Int = 0,
    val createDate: Date,
    val modifyDate: Date? = null,
    val title: String,
    val content: String? = null,
    val imageUrl: String? = null,
)
