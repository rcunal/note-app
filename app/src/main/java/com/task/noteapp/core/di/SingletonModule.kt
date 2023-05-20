package com.task.noteapp.core.di

import com.task.noteapp.features.add_note_view_note.common.data.repository.NoteRepositoryImpl
import com.task.noteapp.features.add_note_view_note.common.data.usecase.DeleteNoteUseCaseImpl
import com.task.noteapp.features.add_note_view_note.common.data.usecase.SaveNoteUseCaseImpl
import com.task.noteapp.features.add_note_view_note.common.domain.repository.NoteRepository
import com.task.noteapp.features.add_note_view_note.common.domain.usecase.DeleteNoteUseCase
import com.task.noteapp.features.add_note_view_note.common.domain.usecase.SaveNoteUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author: R. Cemre Ünal,
 * created on 9/21/2022
 */

@Module
@InstallIn(SingletonComponent::class)
interface AbstractSingletonModule {
    @Binds
    @Singleton
    fun bindRepository(noteRepositoryImpl: NoteRepositoryImpl): NoteRepository

    @Binds
    fun bindsSaveNoteUseCase(saveNoteUseCaseImpl: SaveNoteUseCaseImpl): SaveNoteUseCase

    @Binds
    fun bindsDeleteNoteUseCase(deleteNoteUseCaseImpl: DeleteNoteUseCaseImpl): DeleteNoteUseCase
}