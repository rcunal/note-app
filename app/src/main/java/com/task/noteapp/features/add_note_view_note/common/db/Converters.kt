package com.task.noteapp.features.add_note_view_note.common.db

import androidx.room.TypeConverter
import java.util.*

/**
 * @author: R. Cemre Ünal,
 * created on 9/22/2022
 */
class Converters {

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }
}