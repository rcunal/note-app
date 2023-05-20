package com.noteapp.datasource.local

import android.app.Application
import androidx.room.Room
import com.noteapp.datasource.local.db.NoteDao
import com.noteapp.datasource.local.db.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SingletonModule {
    @Provides
    @Singleton
    fun provideNoteDao(app: Application): NoteDao {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NOTE_DATABASE_NAME
        ).fallbackToDestructiveMigration().build().noteDao
    }
}

private const val NOTE_DATABASE_NAME = "note_database"