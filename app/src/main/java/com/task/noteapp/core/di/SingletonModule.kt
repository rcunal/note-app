package com.task.noteapp.core.di

import com.noteapp.note_details.data.NoteDetailsRepositoryImpl
import com.noteapp.note_details.data.usecase.DeleteNoteUseCaseImpl
import com.noteapp.note_details.data.usecase.SaveNoteUseCaseImpl
import com.noteapp.note_details.domain.NoteDetailsRepository
import com.noteapp.note_details.domain.usecase.DeleteNoteUseCase
import com.noteapp.note_details.domain.usecase.SaveNoteUseCase
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
    fun bindRepository(noteDetailsRepositoryImpl: NoteDetailsRepositoryImpl): NoteDetailsRepository

    @Binds
    fun bindsSaveNoteUseCase(saveNoteUseCaseImpl: SaveNoteUseCaseImpl): SaveNoteUseCase

    @Binds
    fun bindsDeleteNoteUseCase(deleteNoteUseCaseImpl: DeleteNoteUseCaseImpl): DeleteNoteUseCase
}