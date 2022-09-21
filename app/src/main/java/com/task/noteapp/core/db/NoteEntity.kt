package com.task.noteapp.core.db

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

/**
 * @author: R. Cemre Ünal,
 * created on 9/21/2022
 */

@Parcelize
@Entity
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val dbId: Int,
    val title: String,
    val description: String? = null,
    val imageUrl: String? = null
) : Parcelable
