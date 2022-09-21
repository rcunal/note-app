package com.task.noteapp.core.db

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * @author: R. Cemre Ünal,
 * created on 9/21/2022
 */
@Database(
    entities = [NoteEntity::class],
    version = 1
)
abstract class NoteDatabase : RoomDatabase() {
    abstract val noteDao: NoteDao
}