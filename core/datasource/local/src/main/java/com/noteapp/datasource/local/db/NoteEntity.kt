package com.noteapp.datasource.local.db

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
