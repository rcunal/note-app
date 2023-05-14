package com.task.noteapp.core.di

import android.app.Application
import androidx.room.Room
import com.task.noteapp.core.utils.Constant.NOTE_DATABASE_NAME
import com.task.noteapp.features.add_note_view_note.common.data.repository.NoteRepositoryImpl
import com.task.noteapp.features.add_note_view_note.common.data.usecase.DeleteNoteUseCaseImpl
import com.task.noteapp.features.add_note_view_note.common.data.usecase.GetNotesUseCaseImpl
import com.task.noteapp.features.add_note_view_note.common.data.usecase.SaveNoteUseCaseImpl
import com.task.noteapp.features.add_note_view_note.common.db.NoteDatabase
import com.task.noteapp.features.add_note_view_note.common.domain.repository.NoteRepository
import com.task.noteapp.features.add_note_view_note.common.domain.usecase.DeleteNoteUseCase
import com.task.noteapp.features.add_note_view_note.common.domain.usecase.GetNotesUseCase
import com.task.noteapp.features.add_note_view_note.common.domain.usecase.SaveNoteUseCase
import dagger.Binds
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

@Module
@InstallIn(SingletonComponent::class)
interface AbstractSingletonModule {
    @Binds
    @Singleton
    fun bindRepository(noteRepositoryImpl: NoteRepositoryImpl): NoteRepository

    @Binds
    fun bindsSaveNoteUseCase(saveNoteUseCaseImpl: SaveNoteUseCaseImpl): SaveNoteUseCase

    @Binds
    fun bindsGetNotesUseCase(getNotesUseCaseImpl: GetNotesUseCaseImpl): GetNotesUseCase

    @Binds
    fun bindsDeleteNoteUseCase(deleteNoteUseCaseImpl: DeleteNoteUseCaseImpl): DeleteNoteUseCase
}