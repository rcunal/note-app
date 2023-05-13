package com.task.noteapp.core.di

import android.app.Application
import androidx.room.Room
import com.task.noteapp.core.utils.Constant.NOTE_DATABASE_NAME
import com.task.noteapp.features.add_note_view_note.common.db.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

/**
 * @author: R. Cemre Ünal,
 * created on 9/21/2022
 */

@Module
@InstallIn(SingletonComponent::class)
object SingletonModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NOTE_DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }

    @[Provides Singleton IoDispatcher]
    fun provideDispatcher(): CoroutineDispatcher = Dispatchers.IO
}